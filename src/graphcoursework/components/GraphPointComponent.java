/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.components;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphcoursework.graph.*;

/**
 *
 * @author alex
 */
public class GraphPointComponent extends GraphComponent{
    
    public static final int COMPONENT_SIZE = 40;
    
    public static final int SIZE = COMPONENT_SIZE - 1;

    //public static Color SELECT_COLOR = new Color(0,204,0);
    //public static Color NOSELECT_COLOR = Color.BLACK;
    
    public static final int CIRCLE_RAD_SELECT = (SIZE / 2) / 2;
    public static final int CIRCLE_RAD_NOSELECT = (SIZE / 2) / 2;
    
    public static final int CIRCLE_BORDER_RAD_SELECT = (SIZE - 1) / 2;
    public static final int CIRCLE_BORDER_RAD_NOSELECT = (SIZE - 1) / 2;
    
    private int x, y;
    private int centerx, centery;
    
    private boolean TEST = false;
    
//    {
//        GraphPointComponent.SELECT_COLOR = new Color(0,204,0);
//        GraphPointComponent.NOSELECT_COLOR  = new Color(0,204,0);
//    }
    
    @Override
    public Point getLocation() {
        return new Point(x, y);
    }
    
    public Point getCenter() {
        return new Point(centerx, centery);
    }
    
    @Override
    public Dimension getSize() {
        return new Dimension(SIZE, SIZE);
    }
    
    public GraphPointComponent(GraphPoint gp, int x, int y) {
        
        super(gp);
        setOpaque(true);
        this.x = x - SIZE / 2;
        this.y = y - SIZE / 2;
        this.centerx = x;
        this.centery = y;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        //this.setSize(50, 50);
        //this.setLocation(x, y);
        
        System.out.println("GraphPoint.paintComponent");
        Graphics2D g2d = (Graphics2D)g;
        
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Color col = isSelected ? SELECT_COLOR : NOSELECT_COLOR;
        int rad = getSelect() ? CIRCLE_RAD_SELECT :  CIRCLE_RAD_NOSELECT;
        int radbor = getSelect() ? CIRCLE_BORDER_RAD_SELECT :  CIRCLE_BORDER_RAD_NOSELECT;
        
        g2d.setColor(getColor());
        //g2d.setBackground(col);
        
        g2d.fillOval((SIZE / 2) - rad, (SIZE / 2) - rad, rad * 2, rad * 2);
        g2d.drawOval(0, 0, radbor * 2, radbor * 2);
        
        // DRAW BORDER
        
        if(!TEST) return;
        
        g2d.drawRect(0, 0, SIZE - 1, SIZE - 1);
        
        System.out.println("GraphPoint.paintComponent");
    }
    
    @Override
    public boolean contains(int x, int y) {
        //System.out.println("contains");
        //return super.contains(x, y);
        int radbor = getSelect() ? CIRCLE_BORDER_RAD_SELECT :  CIRCLE_BORDER_RAD_NOSELECT;
        //return false; //x * x
        int xx = x - radbor, yy = y - radbor;
        return (xx * xx) + (yy * yy) <= (radbor * radbor);
    }
    
}
