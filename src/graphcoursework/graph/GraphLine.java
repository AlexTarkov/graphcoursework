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
public class GraphLine extends GraphElement{
    
    private int weight = -Integer.MIN_VALUE;
    
    private GraphPoint point1, point2;
    
    GraphLine(int id) {
        super(id);
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    
    GraphLine(Graph g, int id, GraphComponent gc, GraphPoint point1, GraphPoint point2) {
        super(g, id, gc);
        this.point1 = point1;
        this.point2 = point2;
    }
    
    GraphLine(Graph g, int id, GraphPoint point1, GraphPoint point2) {
        super(g, id);
        this.point1 = point1;
        this.point2 = point2;
    }
}
