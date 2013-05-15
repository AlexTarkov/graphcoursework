/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.graph;

import java.util.*;

import graphcoursework.components.*;

/**
 *
 * @author alex
 */
public class GraphPoint extends GraphElement{
    
    private HashMap<Integer, GraphLine> lines = new HashMap();
    
    public GraphPoint(int id) {
        super(id);
    }
    
    public GraphPoint(Graph g,int id) {
        super(g, id);
    }
    
    public GraphPoint(Graph g, int id, GraphComponent gc) {
        super(g, id, gc);
    }
    
    public void addLine(GraphLine gl) {
        lines.put(gl.getId(), gl);
    }
    
    public void removeLine(GraphLine gl) {
        lines.remove(gl.getId());
    }
    
    public HashMap getLines() {
        return this.lines;
    }
    
}
