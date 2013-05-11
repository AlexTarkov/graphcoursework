/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.components;

import graphcoursework.graph.Graph;
import graphcoursework.graph.GraphElement;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class GraphComponent extends JComponent{
    
    private boolean selected = false;
    private Color currentcolor = NOSELECT_COLOR;
    private GraphElement graphelement;
    
    public static Color SELECT_COLOR = new Color(0, 204, 0);
    public static Color NOSELECT_COLOR = new Color(0,0,0);
    
    
    public GraphComponent(GraphElement ge) {
        this();
        this.graphelement = ge;
    }
    
    public GraphComponent() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("ComponentClick.");
                GraphComponent gc = (GraphComponent)e.getSource();
                if (e.getButton() == 1) {
                    gc.changeSelect();
                    return;
                }
                
                Graph graph = gc.getGraphElement().getGraph();
                //System.out.println("Graph: " + graph);
                //System.out.println("GraphPoint: " + gpc.getGraphPoint());
                if (e.getButton() == 3) {
                    graph.removeElement(gc.getGraphElement());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("mousePressed - " + e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("mouseReleased - " + e.getButton());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("mouseEntered - " + e.getButton());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("mouseExited - " + e.getButton());
            }
        });
    }
    
    public void setColor(Color newcolor) {
        this.currentcolor = newcolor;
        stateChange();
    }
    
    public Color getColor() {
        return this.currentcolor;
    }
    
    public boolean getSelect() {
        return this.selected;
    }
    
    public void setSelect(boolean select) {
        this.selected = select;
        this.setColor(getSelect() ? this.SELECT_COLOR : this.NOSELECT_COLOR);
        //this.stateChange();
    }
    
    public void changeSelect() {
        setSelect(!selected);
    }
    
    public void stateChange() {
        this.repaint();
    }
    
    public void setGraphElement(GraphElement ge) {
        this.graphelement = ge;
    }
    
    public GraphElement getGraphElement() {
        return this.graphelement;
    }
    
}
