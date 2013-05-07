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
public class GraphPoint extends JComponent{
    
    public static final int COMPONENT_SIZE = 30;
    
    public static final int SIZE = COMPONENT_SIZE - 1;

    public static final Color SELECT_COLOR = Color.GREEN;
    public static final Color NOSELECT_COLOR = Color.BLACK;
    
    public static final int CIRCLE_RAD_SELECT = SIZE / 2;
    public static final int CIRCLE_RAD_NOSELECT = SIZE / 2;
    
    public static final int CIRCLE_BORDER_RAD_SELECT = SIZE - 1;
    public static final int CIRCLE_BORDER_RAD_NOSELECT = SIZE - 1;
    
    private boolean isSelected = false;
    
    private int x, y;
    
    @Override
    public Point getLocation() {
        return new Point(x, y);
    }
    
    @Override
    public Dimension getSize() {
        return new Dimension(SIZE, SIZE);
    }
    
    public void setSelect(boolean s) {
        this.isSelected = s;
    }
    
    public boolean getSelect() {
        return this.isSelected;
    }
    
//    @Override
//    public void setLocation(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }

    
    public GraphPoint(int x, int y) {
        setOpaque(true);
        this.x = x - SIZE / 2;
        this.y = y - SIZE / 2;
        //setOpaque(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        //this.setSize(50, 50);
        //this.setLocation(x, y);
        
        System.out.println("GraphPoint.paintComponent");
        Graphics2D g2d = (Graphics2D)g;
        
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Color col = isSelected ? SELECT_COLOR : NOSELECT_COLOR;
        int rad = isSelected ? CIRCLE_RAD_SELECT :  CIRCLE_RAD_NOSELECT;
        int radbor = isSelected ? CIRCLE_BORDER_RAD_SELECT :  CIRCLE_BORDER_RAD_NOSELECT;
        
        g2d.setColor(col);
        //g2d.setBackground(col);
        
        g2d.fillOval((SIZE - rad) / 2, (SIZE - rad) / 2, rad, rad);
        g2d.drawOval(0, 0, radbor, radbor);
        System.out.println("GraphPoint.paintComponent");
        
        
        
        //super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D)g;
//        //g2d.setClip(0,0, getWidth(), getHeight() * 2);
//        //g2d.setClip(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
//        
//        g2d.setColor(Color.blue);
//        g2d.fillOval(10, 10, getWidth() - 20, getHeight() * 2 - 20);
//        g2d.setColor(Color.red);
//        g2d.fillOval(20, 20, getWidth() - 40, getHeight() - 40);
//        g2d.setColor(Color.yellow);
//        g2d.fillOval(30, 30, getWidth() - 60, getHeight() - 60);
//        g2d.setColor(Color.black);
//        g2d.fillOval(getWidth()/4 - getWidth()/16, getHeight()/2-getHeight()/8, getWidth()/8, getHeight()/8);
//        g2d.fillOval(getWidth()*3/4 - getWidth()/16, getHeight()/2-getHeight()/8, getWidth()/8, getHeight()/8);
//        g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//        g2d.drawArc(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2, 225, 90);
        
    }
    
    public void remove() {
        this.getParent().remove(this);
    }
    
    public void changeSelect() {
        this.setSelect(!isSelected);
    }
    
}
