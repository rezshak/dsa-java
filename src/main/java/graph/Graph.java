package main.java.graph;

import java.util.*;

// Undirected unweighted graph
public final class Graph {

    private final Map<String, Vertex> vertices;
    private final Map<Vertex, Set<Vertex>> adjList;
    private int edgeCount;

    // T: O(1), S: O(1)
    public Graph() {
        vertices = new HashMap<>();
        adjList = new HashMap<>();
        edgeCount = 0;
    }

    // T: O(1), S: O(1)
    public void addVertex(String name) {
        var vertex = new Vertex(name);
        vertices.putIfAbsent(name, vertex);
        adjList.putIfAbsent(vertex, new HashSet<>());
    }

    // T: O(V+E), S: O(V+E)
    public void removeVertex(String name) {
        var vertex = vertices.get(name);
        if (vertex == null)
            return;

        for (var neighbors : adjList.values())
            neighbors.remove(vertex);

        adjList.remove(vertex);
        vertices.remove(name);
    }

    // T: O(1), S: O(1)
    public void addEdge(String from, String to) {
        var fromVertex = vertices.get(from);
        if (fromVertex == null)
            throw new IllegalArgumentException("From vertex not found");

        var toVertex = vertices.get(to);
        if (toVertex == null)
            throw new IllegalArgumentException("To vertex not found");

        adjList.get(fromVertex).add(toVertex);
        adjList.get(toVertex).add(fromVertex);
        edgeCount++;
    }

    // T: O(1), S: O(1)
    public void removeEdge(String from, String to) {
        var fromVertex = vertices.get(from);
        var toVertex = vertices.get(to);
        if (fromVertex == null || toVertex == null)
            return;

        adjList.get(fromVertex).remove(toVertex);
        adjList.get(toVertex).remove(fromVertex);
        edgeCount--;
    }

    // T: O(V), S: O(V)
    public Set<Vertex> getVertices() {
        return new HashSet<>(adjList.keySet());
    }

    // T: O(V+E), S: O(V+E)
    public Set<Pair<Vertex>> getEdges() {
        var edges = new HashSet<Pair<Vertex>>();
        for (var vertex : adjList.keySet())
            for (var neighbor : adjList.get(vertex))
                edges.add(new Pair<>(vertex, neighbor));

        return edges;
    }

    // T: O(1), S: O(1)
    public boolean isAdjacent(String from, String to) {
        var fromVertex = vertices.get(from);
        var toVertex = vertices.get(to);
        if (fromVertex == null || toVertex == null)
            return false;
        return adjList.get(fromVertex).contains(toVertex);
    }

    // T: O(1), S: O(1)
    public int getVertexCount() {
        return adjList.size();
    }

    // T: O(V+E), S: O(1)
    public int getEdgeCount() {
        return edgeCount;
    }

    // T: O(1), S: O(1)
    public Set<Vertex> getNeighbors(String name) {
        var vertex = vertices.get(name);
        if (vertex == null)
            throw new IllegalArgumentException("Vertex not found");

        return adjList.get(vertex);
    }

    // T: O(V+E), S: O(V)
    public void dfs(String start) {
        var visited = new HashSet<Vertex>();
        var stack = new Stack<Vertex>();
        stack.push(vertices.get(start));
        while (!stack.isEmpty()) {
            var curr = stack.pop();
            if (!visited.contains(curr)) {
                visited.add(curr);
                System.out.print(curr + " ");
                for (var neighbor : adjList.get(curr))
                    if (!visited.contains(neighbor))
                        stack.push(neighbor);
            }
        }
    }

    // T: O(V+E), S: O(V)
    public void dfsRecHelper(String start) {
        var vertex = vertices.get(start);
        if (vertex == null)
            return;

        dfsRecHelper(vertex,  new HashSet<>());
    }

    // T: O(V+E), S: O(V)
    private void dfsRecHelper(Vertex curr, Set<Vertex> visited) {
        visited.add(curr);
        System.out.print(curr + " ");
        for (var neighbor : adjList.get(curr))
            if (!visited.contains(neighbor))
                dfsRecHelper(neighbor, visited);
    }

    // T: O(V+E), S: O(V)
    public void bfs(String start) {
        var visited = new HashSet<Vertex>();
        var queue = new LinkedList<Vertex>();
        queue.add(vertices.get(start));
        while (!queue.isEmpty()) {
            var curr = queue.remove();
            if (!visited.contains(curr)) {
                visited.add(curr);
                System.out.print(curr + " ");
                for (var neighbor : adjList.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    // T: O(V+E), S: O(V)
    public List<String> topologicalSort() {
        var indegree = new HashMap<Vertex, Integer>();

        for (var vertex : adjList.keySet())
            for (var neighbor : adjList.get(vertex))
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);

        var queue = new LinkedList<Vertex>();
        for (var vertex : indegree.keySet())
            if (indegree.get(vertex) == 0)
                queue.add(vertex);

        var visited = new ArrayList<Vertex>();
        while (!queue.isEmpty()) {
            var curr = queue.remove();
            visited.add(curr);
            for (var neighbor : adjList.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }

        if (visited.size() != adjList.size()) {
            System.out.println("There exists a cycle in the graph");
            return Collections.emptyList();
        }

        var sorted = new ArrayList<String>();
        for (var vertex : visited)
            sorted.add(vertex.toString());

        return sorted;
    }

    // T: O(V+E), S: O(V)
    public List<String> topologicalSortRec() {
        var visited = new HashSet<Vertex>();
        var stack = new Stack<Vertex>();
        for (var vertex : vertices.values())
                topologicalSortRecHelper(vertex, visited, stack);

        var sorted = new ArrayList<String>();
        while (!stack.isEmpty())
            sorted.add(stack.pop().name());

        return sorted;
    }

    // T: O(V+E), S: O(V)
    private void topologicalSortRecHelper(Vertex curr, Set<Vertex> visited, Stack<Vertex> stack) {
        visited.add(curr);
        for (var neighbor : adjList.get(curr))
            if (!visited.contains(neighbor))
                topologicalSortRecHelper(neighbor, visited, stack);

        stack.push(curr);
    }

    // T: O(V+E), S: O(V)
    public boolean hasCycle() {
        var visited = new HashSet<Vertex>();
        var visiting = new HashSet<Vertex>();
        var stack = new Stack<Vertex>();
        for (var vertex : vertices.values())
            stack.push(vertex);

        while (!stack.isEmpty()) {
            var curr = stack.pop();
            if (visiting.contains(curr))
                return true;

            if (visited.contains(curr))
                continue;

            visited.add(curr);
            visiting.add(curr);
            for (var neighbor : adjList.get(curr))
                stack.push(neighbor);

            visiting.remove(curr);
        }

        return false;
    }

    // T: O(V+E), S: O(V)
    public boolean hasCycleRec() {
        for (var vertex : vertices.values())
            if (hasCycleRecHelper(vertex, new HashSet<>(), new HashSet<>()))
                return true;

        return false;
    }

    // T: O(V+E), S: O(V)
    private boolean hasCycleRecHelper(Vertex curr, Set<Vertex> visited, Set<Vertex> visiting) {
        if (visiting.contains(curr))
            return true;

        if (visited.contains(curr))
            return false;

        visited.add(curr);
        visiting.add(curr);
        for (var neighbor : adjList.get(curr))
            if (hasCycleRecHelper(neighbor, visited, visiting))
                return true;

        visiting.remove(curr);
        return false;
    }

    public static void main(String[] args) {
        var graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        System.out.println("Vertices: " + graph.getVertices());
        System.out.println("Edges: " + graph.getEdges());

        System.out.println("Vertex count: " + graph.getVertexCount());
        System.out.println("Edge count: " + graph.getEdgeCount());

        System.out.print("\nNeighbors of vertex A: ");
        System.out.println(graph.getNeighbors("A"));

        System.out.println("Is vertex A adjacent to vertex B? " + graph.isAdjacent("A", "B"));
        System.out.println("Is vertex A adjacent to vertex D? " + graph.isAdjacent("A", "D"));

        System.out.print("\nDFS traversal from vertex A: ");
        graph.dfs("A");
        System.out.print("\nBFS traversal from vertex A: ");
        graph.bfs("A");
        System.out.println();

        graph.removeEdge("A", "B");
        graph.removeVertex("C");
        System.out.println("\nRemoved edge (A, B) and vertex C");
        System.out.println("Vertices: " + graph.getVertices());
        System.out.println("Edges: " + graph.getEdges());
    }

}
