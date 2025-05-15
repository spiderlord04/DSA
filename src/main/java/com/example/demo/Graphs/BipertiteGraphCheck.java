package com.example.demo.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipertiteGraphCheck {
    class Edge {
        int src;
        int dest, weight;

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

        // Example graph creation (you can modify as needed)
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[0].add(new Edge(0, 3, 1));
        // graph[4].add(new Edge(4, 3, 1));

        // graph[4].add(new Edge(4, 0, 1));
        // graph[0].add(new Edge(0, 4, 1));


    }

    // Function to check if a graph is bipartite using BFS
    public boolean isBipertite(ArrayList<Edge>[] graph) {
        // Array to store colors of vertices.
        // -1 means unvisited, 0 and 1 are the two colors we will use.
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // initialize all vertices as unvisited
        }

        // Check each connected component of the graph
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // if not yet colored
                if (!isBipertiteUtil(graph, color, i))
                    return false; // if any component is not bipartite
            }
        }
        return true; // if all components are bipartite
    }

    // Helper function to perform BFS and check for bipartiteness starting from
    // 'curr' vertex
    private boolean isBipertiteUtil(ArrayList<Edge>[] graph, int color[], int curr) {
        Queue<Integer> q = new LinkedList<>();
        color[curr] = 0; // Assign first color (say 0) to the starting vertex
        q.add(curr);

        // Standard BFS loop
        while (!q.isEmpty()) {
            int src = q.remove();

            // Check all neighbors of current vertex
            for (int i = 0; i < graph[src].size(); i++) {
                Edge e = graph[src].get(i);
                int neighbor = e.dest;

                /*
                 * 3 Important Cases while coloring:
                 * 
                 * Case 1: If neighbor is uncolored, color it with alternate color of current
                 * node.
                 * Case 2: If neighbor is already colored with the same color as current, graph
                 * is not bipartite.
                 * Case 3: If neighbor is already colored with a different color, no problem —
                 * continue.
                 */

                if (color[neighbor] == -1) {
                    // Case 1: Color with alternate color and enqueue
                    color[neighbor] = 1 - color[src];
                    q.add(neighbor);
                } else if (color[neighbor] == color[src]) {
                    // Case 2: Conflict found, graph is not bipartite
                    return false;
                }
                // Case 3: Already colored with different color — fine, keep going.
            }
        }
        return true; // No conflicts, this component is bipartite
    }

    public static void main(String[] args) {
        BipertiteGraphCheck b = new BipertiteGraphCheck();
        ArrayList<Edge>[] graph = new ArrayList[4];
        b.createGraph(graph);
        System.out.println(b.isBipertite(graph));
    }
}
