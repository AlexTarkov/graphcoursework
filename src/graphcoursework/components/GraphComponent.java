/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.components;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class GraphComponent extends JComponent{
    
    private boolean selected = false;
    private Color currentcolor;
    
    public static Color SELECT_COLOR = new Color(0,204,0);
    public static Color NOSELECT_COLOR = new Color(0,0,0);
    
    public void setColor(Color newcolor) {
        this.currentcolor = newcolor;
        stateChange();
    }
    
    public boolean getSelect() {
        return this.selected;
    }
    
    public void setSelect(boolean select) {
        this.selected = select;
        this.currentcolor = select ? SELECT_COLOR : NOSELECT_COLOR;
        this.stateChange();
    }
    
    public void changeSelect() {
        setSelect(!selected);
    }
    
    public void stateChange() {
        this.repaint();
    }
    
}
