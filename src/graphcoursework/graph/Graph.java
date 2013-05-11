/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.graph;

import graphcoursework.components.*;
import java.awt.Component;
//import java.awt.GradientPaint;
import java.util.*;
//import java.util.
import javax.swing.*;

/**
 *
 * @author alex
 */
public class Graph {
    
    private int POINT_ID;
    private int LINE_ID;
    
    private HashMap<Integer, GraphPoint> points;
    
    private HashMap<Integer, GraphLine> lines;
    
    //private HashMap<Integer, HashMap<Integer, GraphPoint>> graphmap;
    
    private JPanel panel;
    
    private int getPOINT_ID() {
        return this.POINT_ID++;
    }
    
    private int getLINE_ID() {
        return this.LINE_ID++;
    }
    
    public Graph(JPanel panel) {
        this.POINT_ID = 0;
        this.LINE_ID = 0;
        this.points = new HashMap();
        this.lines = new HashMap();
        this.panel = panel;
    }
    
    public void addPoint(GraphPointComponent gpc) {
        GraphPoint gp = new GraphPoint(this, this.getPOINT_ID(), gpc);
        this.points.put(gp.getId(), gp);
        
        Component cp = panel.add(gpc);
        cp.setLocation(gpc.getLocation());
        cp.setSize(gpc.getSize());
        panel.repaint();
    }
    
    public void addPoint(int x, int y) {
        GraphPoint gp = new GraphPoint(this, this.getPOINT_ID());
        GraphPointComponent gpc = new GraphPointComponent(gp, x, y);
        gp.setComponent(gpc);
        this.points.put(gp.getId(), gp);
        
        Component cp = panel.add(gpc);
        cp.setLocation(gpc.getLocation());
        cp.setSize(gpc.getSize());
        panel.repaint();
    }
    
    public void removePoint(GraphPoint gp) {
        points.remove(gp.getId());
        panel.remove(gp.getComponent());
        panel.repaint();
    }
    
    public void addLine(GraphPoint gp1, GraphPoint gp2) {
        GraphLine gl = new GraphLine(this, getLINE_ID(), gp1, gp2);
        this.lines.put(gl.getId(), gl);
        
        GraphLineComponent glc = new GraphLineComponent(gl, (GraphPointComponent)gp1.getComponent(), (GraphPointComponent)gp2.getComponent());
        //ИЗМЕНИТЬ АПИ СОЗДАНИЯ РЕБРА И ЭТОТ ВЫЗОВ
        
        gl.setComponent(glc);
        
        Component cp = panel.add(glc);
        cp.setLocation(glc.getLocation());
        cp.setSize(glc.getSize());
        panel.repaint();
    }
    
    public void removeLine(GraphLine gl) {
        lines.remove(gl.getId());
        panel.remove(gl.getComponent());
        panel.repaint();
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
        
        GraphPoint[] gps = new GraphPoint[buffer.size()];
        
        for (int i = 0; i < buffer.size(); i++) {
            gps[i] = buffer.get(i);
        }
        
        return gps;
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
        panel.repaint();
    }
    
}
