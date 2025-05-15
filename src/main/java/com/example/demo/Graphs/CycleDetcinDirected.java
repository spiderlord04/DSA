package com.example.demo.Graphs;
import java.util.ArrayList;

public class CycleDetcinDirected {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public boolean cycleDetection(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];
        // comp : Loop through all vertices to handle disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (cycleDetectionUtil(graph, visited, recStack, i)) {
                    return true;
                }
            }
        }
        return false;

    }

    // dfs modified..
    private boolean cycleDetectionUtil(ArrayList<Edge> graph[], boolean visited[], boolean recStack[], int curr) {
        visited[curr] = true;
        // recStack keeps track of nodes currently in the current DFS recursion path
        // If we encounter a node that's already in recStack, it means there's a back
        // edge,
        // which forms a cycle in a directed graph
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbor = e.dest;

            // Case 1: If neighbor is already in recursion stack, cycle exists
            if (recStack[neighbor]) {
                return true;
            }

            // Case 2: If neighbor not visited, do DFS recursively
            if (!visited[neighbor] && cycleDetectionUtil(graph, visited, recStack, neighbor) ){
                // if(cycleDetectionUtil(graph, visited, recStack, neighbor)){
                //     return true;
                // };} 
                return true;
            }
        }

        recStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0)); // cycle here
        graph[2].add(new Edge(2, 3));

        CycleDetcinDirected cd = new CycleDetcinDirected();
        boolean result = cd.cycleDetection(graph);
        System.out.println("Cycle detected? " + result);
    }

}
