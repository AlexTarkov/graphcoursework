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

import static debug.Debug.*;

import graphcoursework.graph.*;

/**
 *
 * @author alex
 */
public class GraphPointComponent extends GraphComponent{
    
    public static final int COMPONENT_SIZE = 40;
    
    public static final int SIZE = COMPONENT_SIZE - 1;

    public static final int CIRCLE_RAD_SELECT = (SIZE / 2) / 2;
    public static final int CIRCLE_RAD_NOSELECT = (SIZE / 2) / 2;
    
    public static final int CIRCLE_BORDER_RAD_SELECT = (SIZE - 1) / 2;
    public static final int CIRCLE_BORDER_RAD_NOSELECT = (SIZE - 1) / 2;
    
    private int x, y;
    private int centerx, centery;
    
    private boolean TEST = false;
    
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

        dbg("GraphPoint.paintComponent");
        Graphics2D g2d = (Graphics2D)g;

        int rad = getSelect() ? CIRCLE_RAD_SELECT :  CIRCLE_RAD_NOSELECT;
        int radbor = getSelect() ? CIRCLE_BORDER_RAD_SELECT :  CIRCLE_BORDER_RAD_NOSELECT;
        
        g2d.setColor(getColor());
        
        g2d.fillOval((SIZE / 2) - rad, (SIZE / 2) - rad, rad * 2, rad * 2);
        g2d.drawOval(0, 0, radbor * 2, radbor * 2);
        
        // DRAW BORDER
        
        if(!TEST) return;
        
        g2d.drawRect(0, 0, SIZE - 1, SIZE - 1);
        
        dbg("GraphPoint.paintComponent");
    }
    
    @Override
    public boolean contains(int x, int y) {
        int radbor = getSelect() ? CIRCLE_BORDER_RAD_SELECT :  CIRCLE_BORDER_RAD_NOSELECT;
        int xx = x - radbor, yy = y - radbor;
        return (xx * xx) + (yy * yy) <= (radbor * radbor);
    }
    
}
