package main.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TopologicalSort {

    int nv; // number of vertices
    List<List<Integer>> adj; // adjacency list

    TopologicalSort(int nv) {
        this.nv = nv;
        adj = new ArrayList<>(nv);
        for (int i = 0; i < nv; ++i) {
            adj.add(new LinkedList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSort() {
        int[] indegree = new int[nv];
        for (int i = 0; i < nv; i++) {
            for (int vertex : adj.get(i)) {
                indegree[vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nv; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;
        List<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for (int vertex : adj.get(u)) {
                if (--indegree[vertex] == 0) {
                    queue.add(vertex);
                }
            }
            visited++;
        }

        if (visited != nv) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        for (int vertex : result) {
            System.out.print(vertex + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
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
