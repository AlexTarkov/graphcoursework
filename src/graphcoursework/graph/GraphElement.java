/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.graph;

import graphcoursework.components.GraphComponent;

/**
 *
 * @author alex
 */
public class GraphElement {
    private int id;
    private GraphComponent component;
    private Graph graph;

    public GraphElement(int id) {
        this.id = id;
    }
    
    public GraphElement(Graph g,int id) {
        this.id = id;
        this.graph = g;
    }
    
    public GraphElement(Graph g,int id, GraphComponent gc) {
        this.id = id;
        this.graph = g;
        this.component = gc;
    }
    
    public GraphComponent getComponent() {
        return this.component;
    }
    
    public void setComponent(GraphComponent gc) {
        this.component = gc;
    }
    
    public Graph getGraph() {
        return this.graph;
    }
    
    public int getId() {
        return id;
    }
    
}
