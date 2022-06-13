package graph;

import java.util.LinkedList;

final class AdjacencyListGraph {

    int numVertices;
    LinkedList<Integer>[] adjLists;

    AdjacencyListGraph(int numVertices) {
        this.numVertices = numVertices;
        adjLists = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dst) {
        adjLists[src].add(dst);
    }

    void removeEdge(int src, int dst) {
        LinkedList<Integer> edgeList = adjLists[src];
        for (int i = 0; i < edgeList.size(); i++) {
            if (edgeList.get(i) == dst) {
                edgeList.remove(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            sb.append(i).append(": ");
            sb.append(adjLists[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyListGraph g = new AdjacencyListGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        System.out.println(g);
        g.removeEdge(1, 2);
        System.out.println(g);
    }

}
