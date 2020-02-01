package assignment3;

import java.util.*;

public class Vertex<T> {
    private T name;
    private Map<T, Integer> edges = new HashMap<T, Integer>();

    Vertex(T name){
        this.name = name;
    }

    T getVertexName(){
        return name;
    }

    Map getEdges(){
        return edges;
    }

    public void addEdges(T adjVertex){
        //if edge is not there assign weight = 0, else increase the weight
        int weight;
        if (edges.containsKey(adjVertex)) {
            weight = edges.get(adjVertex);
            weight++;
        }else{
            weight = 1;
        }
        edges.put(adjVertex, weight);
    }

}

