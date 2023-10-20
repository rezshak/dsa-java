package main.java.graph;

import java.util.*;

class TopologicalSort {

    int nv; // number of vertices
    List<List<Integer>> adj; // adjacency list

    TopologicalSort(int nv) {
        this.nv = nv;
        adj = new ArrayList<>(nv);
        for (int i = 0; i < nv; i++) {
            adj.add(new LinkedList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    List<Integer> topologicalSort() {
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
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) {
                    queue.add(v);
                }
            }
            visited++;
        }

        if (visited != nv) {
            System.out.println("There exists a cycle in the graph");
            return Collections.emptyList();
        }

        return result;
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(2, 5);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(g.topologicalSort());
    }

}
