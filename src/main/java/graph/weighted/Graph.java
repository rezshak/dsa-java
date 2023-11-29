package main.java.graph.weighted;

import java.util.*;

// Undirected weighted graph
public class Graph {

    private final Map<String, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String name) {
        var vertex = new Vertex(name, new ArrayList<>());
        vertices.putIfAbsent(name, vertex);
    }

    public void addEdge(String from, String to, int weight) {
        var fromVertex = vertices.get(from);
        if (fromVertex == null)
            throw new IllegalArgumentException("From vertex not found");

        var toVertex = vertices.get(to);
        if (toVertex == null)
            throw new IllegalArgumentException("To vertex not found");

        fromVertex.edges().add(new Edge(toVertex, weight));
        toVertex.edges().add(new Edge(fromVertex, weight));
    }

    // Dijsktra's algorithm
    public int getShortestDistance(String from, String to) {
        var fromVertex = vertices.get(from);
        if (fromVertex == null)
            throw new IllegalArgumentException("From vertex not found");

        var toVertex = vertices.get(to);
        if (toVertex == null)
            throw new IllegalArgumentException("To vertex not found");

        var distances = new HashMap<Vertex, Integer>();
        for (var vertex : vertices.values())
            distances.put(vertex, Integer.MAX_VALUE);

        distances.replace(fromVertex, 0);

        var visited = new HashSet<Vertex>();
        var queue = new PriorityQueue<Vertex>(Comparator.comparingInt(distances::get));
        queue.add(fromVertex);

        while (!queue.isEmpty()) {
            var curr = queue.poll();
            visited.add(curr);

            for (var edge : curr.edges()) {
                if (visited.contains(edge.to()))
                    continue;

                var newDistance = distances.get(curr) + edge.weight();
                if (newDistance < distances.get(edge.to())) {
                    distances.put(edge.to(), newDistance);
                    queue.add(edge.to());
                }
            }
        }

        return distances.get(toVertex);
    }

    // Dijsktra's algorithm
    public List<String> getShortestPath(String from, String to) {
        var fromVertex = vertices.get(from);
        if (fromVertex == null)
            throw new IllegalArgumentException("From vertex not found");

        var toVertex = vertices.get(to);
        if (toVertex == null)
            throw new IllegalArgumentException("To vertex not found");

        var distances = new HashMap<Vertex, Integer>();
        for (var vertex : vertices.values())
            distances.put(vertex, Integer.MAX_VALUE);

        distances.replace(fromVertex, 0);

        var visited = new HashSet<Vertex>();
        var queue = new PriorityQueue<Vertex>(Comparator.comparingInt(distances::get));
        queue.add(fromVertex);

        var previousVertices = new HashMap<Vertex, Vertex>();

        while (!queue.isEmpty()) {
            var curr = queue.poll();
            visited.add(curr);

            for (var edge : curr.edges()) {
                if (visited.contains(edge.to()))
                    continue;

                var newDistance = distances.get(curr) + edge.weight();
                if (newDistance < distances.get(edge.to())) {
                    distances.put(edge.to(), newDistance);
                    previousVertices.put(edge.to(), curr);
                    queue.add(edge.to());
                }
            }
        }

        var path = new LinkedList<String>();
        var curr = toVertex;
        while (curr != null) {
            path.addFirst(curr.name());
            curr = previousVertices.get(curr);
        }

        return path;
    }

    public void print() {
        for (var vertex : vertices.values()) {
            System.out.println(vertex.name() + ": ");
            for (var edge : vertex.edges()) {
                System.out.println("  " + edge.to().name() + "(" + edge.weight() + ") ");
            }
        }
    }

    public static void main(String[] args) {
        var graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.print();
    }

}
