package main.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    private int V; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency List

    // Constructor
    public TopologicalSort(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList();
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // The main function that does the topological sort using Kahn's algorithm
    public void topologicalSort() {
        int indegree[] = new int[V];

        for (int i = 0; i < V; i++) {
            for (int node : adjList[i]) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int visitedNodes = 0;
        LinkedList<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            int m = queue.poll();
            result.add(m);

            for (int node : adjList[m]) {
                if (--indegree[node] == 0)
                    queue.add(node);
            }
            visitedNodes++;
        }

        if (visitedNodes != V) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        for (int i : result)
            System.out.print(i + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        // Create a sample graph
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological Sort");
        g.topologicalSort();
    }
}
