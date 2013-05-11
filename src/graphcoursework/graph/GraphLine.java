/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.graph;

import graphcoursework.components.*;

/**
 *
 * @author alex
 */
public class GraphLine {
    
    private int id;
    
    private int weight = -Integer.MIN_VALUE;
    
    private GraphPoint point1, point2;
    
    private GraphLineComponent component;
    
    private Graph graph;
    
    GraphLine(int id) {
        this.id = id;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    
    GraphLine(Graph graph, int id, GraphPoint point1, GraphPoint point2) {
        this.id = id;
        this.point1 = point1;
        this.point2 = point2;
        this.graph = graph;
    }
    
    public int getId() {
        return id;
    }
    
    public GraphLineComponent getGraphLineComponent() {
        return this.component;
    }
    
    public void setGraphLineComponent(GraphLineComponent glc) {
        this.component = glc;
    }

    public Graph getGraph() {
        return graph;
    }
    
    
    
}
