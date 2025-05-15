package com.example.demo.Graphs;
import java.util.ArrayList;

public class DFS {
    class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    // dfs traversl
    public void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;
        // now checkfor neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            // take the neighbos
            Edge e = graph[curr].get(i);
            int neighbor = e.dest;
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS d = new DFS();
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        boolean visited[] = new boolean[V];
        d.createGraph(graph);
        d.dfs(graph, 0, visited);

    }
}
