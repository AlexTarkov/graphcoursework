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
    public static final float BOLD_NOSELECT = 1;
    public static final int SELECT_RADIUS = 7;
    public static final Color TEXT_COLOR = new Color(0,0,0);
    
    public static final double ANGLE_OF_ARROW = 5 * Math.PI/4;
    public static final double ARROW_LENGTH = 20;
    
    private GraphPointComponent point1, point2;

    
    //centers of connecting point
    private int x1, x2, y1, y2;
    
    private int centersdeviation;
    
    private boolean TEST = false;
    
    public GraphLineComponent(GraphLine gl, GraphPointComponent gp1, GraphPointComponent gp2) {
        super(gl);
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
        
        int x1,x2,y1,y2;
        x1 = point1.getCenter().x - getLocation().x;
        y1 = point1.getCenter().y - getLocation().y;
        x2 = point2.getCenter().x - getLocation().x;
        y2 = point2.getCenter().y - getLocation().y;
        
        g2d.drawLine(x1, y1, x2, y2);
        
        // DRAW ARROW
        double a, b, c;
        a = x2-x1;
        b = y2-y1;
        a *= 0.8;
        b *= 0.8;
        c = Math.sqrt(a*a + b*b);
        double x3,x4,y3,y4;
        // x3 = x1 + 
        x3  = x1 + a + (Math.min(c*0.1, ARROW_LENGTH)) * (Math.cos(ANGLE_OF_ARROW) * (a / c) + Math.sin(ANGLE_OF_ARROW) * (b / c));
        y3  = y1 + b + (Math.min(c*0.1, ARROW_LENGTH)) * (Math.sin(ANGLE_OF_ARROW) * (b / c) - Math.cos(ANGLE_OF_ARROW) * (a / c));
        g2d.drawLine((int)Math.round(x1 + a), (int)Math.round(y1 + b), (int)Math.round(x3), (int)Math.round(y3));
        x3  = x1 + a + (Math.min(c*0.1, ARROW_LENGTH)) * (Math.cos(ANGLE_OF_ARROW) * (a / c) - Math.sin(ANGLE_OF_ARROW) * (b / c));
        y3  = y1 + b + (Math.min(c*0.1, ARROW_LENGTH)) * (Math.sin(ANGLE_OF_ARROW) * (b / c) + Math.cos(ANGLE_OF_ARROW) * (a / c));
        g2d.drawLine((int)Math.round(x1 + a), (int)Math.round(y1 + b), (int)Math.round(x3), (int)Math.round(y3));
        
        g2d.setStroke(temp);
        
        // print text
        
        g2d.setColor(TEXT_COLOR);
        
        int fontwidth = g2d.getFontMetrics(getFont()).getWidths()[7];
        int weight = ((GraphLine)this.getGraphElement()).getWeight();
        // НЕ ДОЛЖНО БЫТЬ ТАК. ВОЗМОЖНО ПОДУМАТЬ НАД АРХИТЕКТУРОЙ
        
        //System.out.println(fontwidth);
        int stringwidht = ((weight+"").length()) * fontwidth;

        g2d.drawString(weight + "", this.x1+centersdeviation + (this.x2-this.x1  - stringwidht) / 2,
                this.y1+centersdeviation + (this.y2-this.y1) / 2);

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
        
        //System.out.println("[ " + x + " " + y + " ]");
        
        double area = (1 / 4.0) * Math.sqrt((a + b + c) * (a + c - b) * 
                (a + b - c) * (b + c - a));
        
        double h = 2 * area / c;
        
        //System.out.println("h = " + h);
        
        return (h <= SELECT_RADIUS) && 
                (x < Math.max(x1, x2) + SELECT_RADIUS) && (y < Math.max(y1, y2) + SELECT_RADIUS) &&
                (x > Math.min(x1, x2) - SELECT_RADIUS) && (y > Math.min(y1, y2) - SELECT_RADIUS);
    }

    
}
