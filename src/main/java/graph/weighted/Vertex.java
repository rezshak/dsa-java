package main.java.graph.weighted;

import java.util.List;

public record Vertex(String name, List<Edge> edges) {

    @Override
    public String toString() {
        return name;
    }

}
