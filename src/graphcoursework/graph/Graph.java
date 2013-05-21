/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.graph;

import static debug.Debug.*;
import graphcoursework.components.*;
import java.awt.Component;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class Graph {
    
    private int POINT_ID;
    private int LINE_ID;
    
    private boolean oriented = false;
    
    private HashMap<Integer, GraphPoint> points;
    
    private HashMap<Integer, GraphLine> lines;
    
    private LinkedHashMap<Integer, GraphElement> selectlist;
    
    //private HashMap<Integer, HashMap<Integer, GraphPoint>> graphmap;
    
    private JPanel panel;
    private JTextField widthfield;
    
    private int getPOINT_ID() {
        return this.POINT_ID++;
    }
    
    private int getLINE_ID() {
        return this.LINE_ID++;
    }
    
    public Graph(JPanel panel, JTextField jtf) {
        this.POINT_ID = 0;
        this.LINE_ID = 0;
        this.points = new HashMap();
        this.lines = new HashMap();
        this.selectlist = new LinkedHashMap();
        this.panel = panel;
        this.widthfield = jtf;
    }
    
    //==========================================================================
    
    public GraphElement[] getDijkstraPath() {
        GraphPoint[] gpm = getSelectedPointInOrder();
        return gpm == null ? null : getDijkstraPath(gpm[0], gpm[1]);
    }
    
    public GraphElement[] getDijkstraPath(GraphPoint gs, GraphPoint gf) {
        GraphElement[] path;
        
        HashMap<Integer, GraphPoint> tocheckpoints = new HashMap(this.points);
        HashMap<Integer, Integer> distanses = new HashMap();
        HashMap<Integer, Integer> from = new HashMap();
        
        int n = tocheckpoints.size();
        // инициализируем множества расстояний и путей
        Iterator<Map.Entry<Integer, GraphPoint>> iterator = tocheckpoints.entrySet().iterator();
        Map.Entry<Integer, GraphPoint> buf;
        while (iterator.hasNext()) {
            buf = iterator.next();
            distanses.put(buf.getKey(), Integer.MAX_VALUE);
            from.put(buf.getKey(), -1);
        }
        
        distanses.put(gs.getId(), 0);

        dbg(points.size());
        
        // основной обход
        while (tocheckpoints.size() > 0) {
            dbg("!!!");
            int min = Integer.MAX_VALUE;
            int minid = -1;
            // ищем минимум
            Iterator<Map.Entry<Integer, Integer>> itdist = distanses.entrySet().iterator();
            while (itdist.hasNext()) {
                Map.Entry<Integer, Integer> buf1 = itdist.next();
                if ((buf1.getValue() < min) && (tocheckpoints.get(buf1.getKey()) != null)) {
                    min = buf1.getValue();
                    minid = buf1.getKey();
                }
            }
            if(minid == -1) {
                break;
            }
            dbg("min = " + min + "; minid = " + minid + "dist = " + distanses.get(minid));
            //удаляем минимум и проверяем все его ветви
            GraphPoint now = tocheckpoints.get(minid);
            tocheckpoints.remove(minid);

            dbg("now size lines = " + now.getLines().size());
            Iterator<Map.Entry<Integer, GraphLine>> itgl = now.getLines().entrySet().iterator();
            Map.Entry<Integer, GraphLine> bufgl;
            while (itgl.hasNext()) {
                bufgl= itgl.next();
                GraphLine gl = bufgl.getValue();
                dbg("gl width = " + gl.getWeight());
                if (this.oriented && (gl.getFirst().getId() != now.getId())) {
                    //dbg("CONTINUE");
                    continue;
                }
                GraphPoint gp = gl.getFirst().getId() != now.getId() ? gl.getFirst() : gl.getSecond();
                // если ориентированный граф, то исправить это
                if (tocheckpoints.get(gp.getId()) != null && 
                        (distanses.get(gp.getId()) > (distanses.get(now.getId()) + gl.getWeight()))) {
                    distanses.put(gp.getId(), distanses.get(now.getId()) + gl.getWeight());
                    from.put(gp.getId(), gl.getId());
                }
            }
        }
        if (from.get(gf.getId()) == -1) return null;
        
        int nowid = gf.getId();
        
        ArrayList<GraphElement> bufferpath = new ArrayList();
        
        int k = 0;
        bufferpath.add(points.get(nowid));
        while (nowid != gs.getId()) {
            int glid = from.get(nowid);
            bufferpath.add(lines.get(glid));
            nowid = lines.get(glid).getFirst().getId() != nowid ? 
                    lines.get(glid).getFirst().getId() :
                    lines.get(glid).getSecond().getId();
            bufferpath.add(points.get(nowid));
        }
        
        return bufferpath.toArray(new GraphElement[0]);
    }
    
    public GraphElement[] getMinimalSpanningTree() {
        GraphLine[] tree = new GraphLine[this.points.size() - 1];
        HashMap<Integer, GraphPoint> gps = new HashMap();
        HashMap<Integer, GraphLine> gls = new HashMap(this.lines);
        int k = 0;
        gps.put(points.keySet().iterator().next(), points.get(points.keySet().iterator().next()));
        dbg("put: " + gps.size());
        while ( k < points.size() - 1) {
            // ищем минимальной длины ребро, соединенное хотя бы с одной вершиной
            int min = Integer.MAX_VALUE;
            int minid = -1;
            Iterator<Map.Entry<Integer, GraphLine>> itdist = gls.entrySet().iterator();
            while (itdist.hasNext()) {
                Map.Entry<Integer, GraphLine> buf1 = itdist.next();
                if (buf1.getValue().getWeight() <= min && 
                        (gps.get(buf1.getValue().getFirst().getId()) != null ||
                        gps.get(buf1.getValue().getSecond().getId()) != null)) {
                    min = buf1.getValue().getWeight();
                    minid = buf1.getKey();
                }
            }
            dbg("!minid = " + minid);
            if (minid == -1) {
                return null;
            }
            // проверяем его на создание циклов
            GraphLine gl = gls.get(minid);
            if (gps.get(gl.getFirst().getId()) != null && gps.get(gl.getSecond().getId()) != null) {
                gls.remove(minid);
                continue;
            }
            tree[k] = gl;
            gps.put(gl.getFirst().getId(), gl.getFirst());
            gps.put(gl.getSecond().getId(), gl.getSecond());
            gls.remove(minid);
            dbg("Add " + k + " * " + gl.getId());
            k++;
        }
        return tree;
        
    }
    
    
    
    //==========================================================================
    
    public void addPoint(GraphPointComponent gpc) {
        GraphPoint gp = new GraphPoint(this, this.getPOINT_ID(), gpc);
        this.points.put(gp.getId(), gp);
        
        Component cp = panel.add(gpc);
        cp.setLocation(gpc.getLocation());
        cp.setSize(gpc.getSize());
        changed();
    }
    
    public GraphPoint addPoint(int x, int y) {
        GraphPoint gp = new GraphPoint(this, this.getPOINT_ID());
        GraphPointComponent gpc = new GraphPointComponent(gp, x, y);
        gp.setComponent(gpc);
        this.points.put(gp.getId(), gp);
        
        Component cp = panel.add(gpc);
        cp.setLocation(gpc.getLocation());
        cp.setSize(gpc.getSize());
        changed();
        return gp;
    }
    
    public void removePoint(GraphPoint gp) {
        Iterator<Map.Entry<Integer, GraphLine>> it = this.lines.entrySet().iterator();
        GraphLine gl;
        while (it.hasNext()) {
            gl = it.next().getValue();
            if (gl.getFirst().getId() == gp.getId() || gl.getSecond().getId() == gp.getId()) {
                it.remove();
                removeLine(gl);
            }
        }
        
        points.remove(gp.getId());
        
        panel.remove(gp.getComponent());
        panel.repaint();
    }
    
    public GraphLine addLine(GraphPoint gp1, GraphPoint gp2) {
        GraphLine gl = new GraphLine(this, getLINE_ID(), gp1, gp2);
        this.lines.put(gl.getId(), gl);
        gp1.addLine(gl);
        gp2.addLine(gl);
        
        GraphLineComponent glc = new GraphLineComponent(gl, (GraphPointComponent)gp1.getComponent(), (GraphPointComponent)gp2.getComponent());
        //ИЗМЕНИТЬ АПИ СОЗДАНИЯ РЕБРА И ЭТОТ ВЫЗОВ
        
        gl.setComponent(glc);
        
        Component cp = panel.add(glc);
        cp.setLocation(glc.getLocation());
        cp.setSize(glc.getSize());
        changed();
        return gl;
    }
    
    public GraphLine addLine() {
        GraphPoint[] gpm = getSelectedPointInOrder();
        return gpm == null ? null : addLine(gpm[0], gpm[1]);
    }
    
    private GraphPoint[] getSelectedPointInOrder() {
        if (this.selectlist.size() != 2) {
            return null;
        }
        Iterator<Map.Entry<Integer, GraphElement>> it = this.selectlist.entrySet().iterator();
        GraphElement gp1 = it.next().getValue();
        GraphElement gp2 = it.next().getValue();
        if (!(GraphPoint.class.isInstance(gp1) && GraphPoint.class.isInstance(gp2))) {
            return null;
        }
        GraphPoint[] gpm = {(GraphPoint)gp1, (GraphPoint)gp2};
        return gpm;
    }
    
    public void removeLine(GraphLine gl) {
        lines.remove(gl.getId());
        points.get(gl.getFirst().getId()).removeLine(gl);
        points.get(gl.getSecond().getId()).removeLine(gl);
        panel.remove(gl.getComponent());
        changed();
    }
    
    public void removeElement(GraphElement ge) {
        if (GraphLine.class.isInstance(ge)) {
            removeLine((GraphLine) ge);
        } else if (GraphPoint.class.isInstance(ge)) {
            removePoint((GraphPoint)ge);
        }
    }
    
    //====================================================API
    
    public GraphPoint[] getSelectedPoints() {
        ArrayList<GraphPoint> buffer = new ArrayList();
        Iterator<Map.Entry<Integer, GraphPoint>> it = points.entrySet().iterator();
        GraphPoint bgp;
        while (it.hasNext()) {
             bgp = it.next().getValue();
            if (bgp.getComponent().getSelect()) {
                buffer.add(bgp);
            }
        }

        GraphPoint[] gps = buffer.toArray(new GraphPoint[0]);

        return gps;
    }
    
    
    public GraphLine[] getSelectedLines() {
        ArrayList<GraphElement> buffer = new ArrayList();
        Iterator<Map.Entry<Integer, GraphLine>> it = lines.entrySet().iterator();
        GraphLine bgp;
        while (it.hasNext()) {
             bgp = it.next().getValue();
            if (bgp.getComponent().getSelect()) {
                buffer.add(bgp);
            }
        }
        
        GraphLine[] gls = buffer.toArray(new GraphLine[0]);
        
        return gls;
    }
    
    public void deselectAll() {
        Iterator<Map.Entry<Integer, GraphPoint>> it1 = points.entrySet().iterator();
        while (it1.hasNext()) {
            it1.next().getValue().getComponent().setSelect(false);
        }
        Iterator<Map.Entry<Integer, GraphLine>> it2 = lines.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().getComponent().setSelect(false);
        }
        changed();
    }
    
    public void changed() {
        this.panel.repaint();
    }
    
    public void setSelectGraphElement(GraphElement ge, boolean b) {
        if (!b) {
            this.selectlist.remove(ge.getId());
        } else {
            this.selectlist.put(ge.getId(), ge);
        }
    }
    
    public void syncWidthField() {
        GraphLine[] gls = getSelectedLines();
        GraphPoint[] gps = getSelectedPoints();
        if (gls.length != 1 || gps.length != 0) return;
        int width = gls[0].getWeight();
        widthfield.setText(width + "");
        //gls[0].setWeight(width);
        changed();
    }
    
    public void syncWidthField(int width) {
        GraphLine[] gls = getSelectedLines();
        if (gls.length != 1) return;
        gls[0].setWeight(width);
        changed();
    }
    
    public void setOriented(boolean t) {
        this.oriented = t;
        changed();
    }
    
}
