package com.example.demo.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

    static void graphCreation(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            // System.out.println(graph[i]);
            // here all the the values in the graph is filled with null values(i.e not empty
            // values)... So we have to
            // fill the graph with empty values(empty lists)..
            graph[i] = new ArrayList<>();
        }
        // now insert ...
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 5, 1));
        graph[4].add(new Edge(4, 2, 1));

        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) {
        // step 1 : take 1 queue and and 1 boolean visited array
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        // step 2 : add first to que
        q.add(0);// first vertex i.e 0 is added

        // step 3 : remove the first node and add its neighbors to the que..continue
        // this process until que is empty
        while (!q.isEmpty()) {
            int curr = q.remove();
            // check if the curr vertex is already visited in graph or not
            if (!visited[curr]) {
                visited[curr] = true;

                System.out.println(curr);
                // if the vertex has neighbors then add them to the que
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }

        }

    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        graphCreation(graph, V);
        bfs(graph);
    }
}
