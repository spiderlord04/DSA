package com.example.demo.Graphs;
import java.util.ArrayList;

public class GraphCreation {

    static class Edge {
        int src;
        int dest;
        int weigth;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weigth = w;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            // System.out.println(graph[i]);
            // here all the the values in the graph is filled with null values(i.e not empty
            // values)... So we have to
            // fill the graph with empty values(empty lists)..
            graph[i] = new ArrayList<>();
        }
        // now insert ...
        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3,2, 1));

        graph[4].add(new Edge(4, 2, 2));
        // to get neighbour of any vertex like 2
        for(int i = 0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}