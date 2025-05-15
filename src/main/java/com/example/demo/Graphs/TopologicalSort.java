
package com.example.demo.Graphs;
import java.util.ArrayList;
import java.util.Stack;




public class TopologicalSort {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    //topological sort is same as the DFS , just a small change we use the stack and store the vetices to print them ..
    public void topologicalSort(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<graph.length;i++){
            if(!visited[i]){
                topologicalSortUtil(graph, visited, i, s);
            }
        }
while (!s.empty()) {
    System.out.print(s.pop());
}
    }
    private void topologicalSortUtil(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer>s){
         // Step 1: Mark current node as visited
        visited[curr] = true;

        // Step 2: Visit all unvisited neighbors
        for(int i = 0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int n = e.dest;
            if(!visited[n]){
                topologicalSortUtil(graph, visited, n, s);
            }
        }
         // Step 3: After visiting neighbors, push current node to stack
        // (because in topological sort, a node should come after all its neighbors in the ordering)
        s.push(curr);
        
    }
    public static void main(String[] args) {
         int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        TopologicalSort ts = new TopologicalSort();
        System.out.print("Topological Sort: ");
        ts.topologicalSort(graph);
        
    
    }

}
