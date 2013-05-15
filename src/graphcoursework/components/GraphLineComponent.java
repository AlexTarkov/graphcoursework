/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.components;

import graphcoursework.graph.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author alex
 */
public class GraphLineComponent extends GraphComponent{
    
    public static final float BOLD_SELECT = 3;
    public static final float BOLD_NOSELECT = 2;
    //public static Color SELECT_COLOR = new Color(204, 0, 0);
    //public static Color NOSELECT_COLOR = new Color(102, 102, 102);
    public static final int SELECT_RADIUS = 7;
    public static final Color TEXT_COLOR = new Color(0,0,0);
    
    private GraphPointComponent point1, point2;

//    {
//        GraphLineComponent.SELECT_COLOR = new Color(0, 204, 0);
//        GraphLineComponent.NOSELECT_COLOR = new Color(102, 102, 102);
//    }
    
    //centers of connecting point
    private int x1, x2, y1, y2;
    
    private int centersdeviation;
    
    private boolean TEST = false;
    
    public GraphLineComponent(GraphLine gl, GraphPointComponent gp1, GraphPointComponent gp2) {
        super(gl);
        //this.TEST = false;
        
        //graphline = gl;
        point1 = gp1;
        point2 = gp2;
        
        x1 = point1.getCenter().x - 
                Math.min(point1.getCenter().x, point2.getCenter().x);
        y1 = point1.getCenter().y - 
                Math.min(point1.getCenter().y, point2.getCenter().y);
        x2 = point2.getCenter().x - 
                Math.min(point1.getCenter().x, point2.getCenter().x);
        y2 = point2.getCenter().y - 
                Math.min(point1.getCenter().y, point2.getCenter().y);
        
        centersdeviation = point1.getSize().width;
    }
     
    //=======================================================COMPONENT FUNC
    @Override
    public Point getLocation() {
        return new Point(Math.min(point1.getCenter().x, point2.getCenter().x) - centersdeviation, 
                Math.min(point1.getCenter().y, point2.getCenter().y) - centersdeviation);
    }
    
    @Override
    public Dimension getSize() {
        //System.out.println();
        return new Dimension(Math.abs(point1.getCenter().x - point2.getCenter().x) + centersdeviation * 2, 
                Math.abs(point1.getCenter().y - point2.getCenter().y) + centersdeviation * 2);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("Line Paint");
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(getColor());
        
        Stroke temp = g2d.getStroke();
        g2d.setStroke(new BasicStroke(this.getSelect() ? BOLD_SELECT : BOLD_NOSELECT));
        g2d.drawLine(
                point1.getCenter().x - getLocation().x, 
                point1.getCenter().y - getLocation().y, 
                point2.getCenter().x - getLocation().x, 
                point2.getCenter().y - getLocation().y);
        g2d.setStroke(temp);
        
        // print text
        
        g2d.setColor(TEXT_COLOR);
        
        int fontwidth = g2d.getFontMetrics(getFont()).getWidths()[7];
        int weight = ((GraphLine)this.getGraphElement()).getWeight();
        // НЕ ДОЛЖНО БЫТЬ ТАК. ВОЗМОЖНО ПОДУМАТЬ НАД АРХИТЕКТУРОЙ
        
        //System.out.println(fontwidth);
        int stringwidht = ((weight+"").length()) * fontwidth;
        //System.out.println("sw = " + stringwidht);
        //g2d.drawString(x1 + " l " + y1, x1 + ((x2-x1) / 2), y1 + ((y2-y1) / 2));
        g2d.drawString(weight + "", x1+centersdeviation + (x2-x1  - stringwidht) / 2,
                y1+centersdeviation + (y2-y1) / 2);
        
        //g2d.drawString(weight + "", 0,10);
        
        if (!TEST) return;
        
        g2d.setColor(new Color(204, 204, 204));
        g2d.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
        
        g2d.drawLine(
                point1.getCenter().x - getLocation().x - SELECT_RADIUS, 
                point1.getCenter().y - getLocation().y + SELECT_RADIUS, 
                point2.getCenter().x - getLocation().x - SELECT_RADIUS, 
                point2.getCenter().y - getLocation().y + SELECT_RADIUS);
        
        g2d.drawLine(
                point1.getCenter().x - getLocation().x + SELECT_RADIUS, 
                point1.getCenter().y - getLocation().y - SELECT_RADIUS, 
                point2.getCenter().x - getLocation().x + SELECT_RADIUS, 
                point2.getCenter().y - getLocation().y - SELECT_RADIUS);
        
        
    }
    
    @Override
    public boolean contains(int x, int y) {
        
        x = x - centersdeviation;
        y = y - centersdeviation;
        
        double a = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
        double b = Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
        
        double c = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        
        //double cos = Math.abs((x1-x2) / gip);
        //double sin = Math.abs((y1-y2) / gip);
        
        //System.out.println("[ " + x + " " + y + " ]");
        
        double area = (1 / 4.0) * Math.sqrt((a + b + c) * (a + c - b) * 
                (a + b - c) * (b + c - a));
        
        double h = 2 * area / c;
        
        //System.out.println("h = " + h);
        
        return (h <= SELECT_RADIUS) && 
                (x < Math.max(x1, x2) + SELECT_RADIUS) && (y < Math.max(y1, y2) + SELECT_RADIUS) &&
                (x > Math.min(x1, x2) - SELECT_RADIUS) && (y > Math.min(y1, y2) - SELECT_RADIUS);
    }
    
    //=======================================================GRAPH FUNC
    
//    public GraphLine getGraphLine() {
//        return this.graphline;
//    }
    
}
