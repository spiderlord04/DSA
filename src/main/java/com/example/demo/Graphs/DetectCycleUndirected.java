package com.example.demo.Graphs;
import java.util.ArrayList;

public class DetectCycleUndirected {
    // We use DFS (Depth-First Search) for detection of cycle in an undirected graph
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
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        

        graph[4].add(new Edge(4, 3, 1));
        
    }

    public boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean res = false;
        // Loop through all vertices, check each disconnected component
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                // For the first node (or any new disconnected component), there will be no
                // parent, so pass -1
                res = detectCycleUtil(graph, visited, i, -1);
            }
        }
        return res;
    }

    public boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        // Mark the current vertex as visited
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbor = e.dest;

            // Cycle detection logic with 3 cases:
            // Case 1: If neighbor is not visited, call DFS recursively
            if (!visited[neighbor]) {
                if (detectCycleUtil(graph, visited, neighbor, curr)) {
                    return true;
                }
            }
            // Case 2: If neighbor is visited and not the parent of current node, cycle is
            // found
            else if (visited[neighbor] && neighbor != parent) {
                return true; // This means that we are visiting a node that is already visited, but it's not
                             // the parent of the current node.
                // This implies there's a cycle.
            }
            // Case 3: If neighbor is parent, ignore and continue (no cycle here)
        }
        return false;
    }
    public static void main(String[] args) {
        DetectCycleUndirected d = new DetectCycleUndirected();
        int v = 5;
        ArrayList<Edge>[]graph = new ArrayList[v];
        d.createGraph(graph);
        System.out.println(d.detectCycle(graph));
    }

}
