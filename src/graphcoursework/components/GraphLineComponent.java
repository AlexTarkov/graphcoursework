/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.components;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author alex
 */
public class GraphLineComponent extends JComponent{
    
    public static final int BOLD_SELECT = 3;
    public static final int BOLD_NOSELECT = 1;
    
    public static final Color SELECT_COLOR = Color.GREEN;
    public static final Color NOSELECT_COLOR = Color.BLACK;
    
    private GraphPointComponent point1, point2;
    
    private boolean isSelected = false;
    
    private int x, y;
    
    private Color currentcolor = NOSELECT_COLOR;
    
    @Override
    public Point getLocation() {
        return new Point(Math.min(point1.getCenter().x, point2.getCenter().x), 
                Math.min(point1.getCenter().y, point2.getCenter().y));
    }
    
    @Override
    public Dimension getSize() {
        //System.out.println();
        return new Dimension(Math.abs(point1.getCenter().x - point2.getCenter().x), 
                Math.abs(point1.getCenter().y - point2.getCenter().y));
    }
    
    public void setSelect(boolean s) {
        this.isSelected = s;
    }
    
    public boolean getSelect() {
        return this.isSelected;
    }
    
    public GraphLineComponent(GraphPointComponent gp1, GraphPointComponent gp2) {
        point1 = gp1;
        point2 = gp2;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("Line Paint");
        
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(currentcolor);
        
        g2d.drawLine(
                point1.getCenter().x - getLocation().x, 
                point1.getCenter().y - getLocation().y, 
                point2.getCenter().x - getLocation().x, 
                point2.getCenter().y - getLocation().y);
        
        g2d.setColor(Color.GRAY);
        g2d.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
        
    }
    
    @Override
    public boolean contains(int x, int y) {
        return false;
        
    }
    
    public void remove() {
        this.getParent().remove(this);
    }
    
    public void changeSelect() {
        this.setSelect(!isSelected);
    }
    
}
