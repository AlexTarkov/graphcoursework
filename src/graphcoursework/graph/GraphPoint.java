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
public class GraphPoint {
    
    private int id;
    
    private GraphPointComponent component;
    
    private Graph graph;
    
    private HashMap<Integer, GraphLine> lines;
    
    GraphPoint(Graph g, int id, GraphPointComponent gp) {
        System.out.println("GraphPointInit");
        this.id = id;
        this.component = gp;
        this.graph = g;
    }
    
    GraphPoint(Graph g, int id) {
        System.out.println("GraphPointInit");
        this.id = id;
        this.graph = g;
        //this.component = gp;
    }
    
    public int getId() {
        return id;
    }
    
    public GraphPointComponent getGraphPointComponent() {
        return this.component;
    }
    
    public Graph getGraph() {
        return this.graph;
    }
    
    protected void setGraphPointComponent(GraphPointComponent gpc) {
        this.component = gpc;
    }
    
    public void addLine(GraphLine gl) {
        lines.put(gl.getId(), gl);
    }
    
    public void removeLine(GraphLine gl) {
        lines.remove(gl.getId());
    }
    
}
