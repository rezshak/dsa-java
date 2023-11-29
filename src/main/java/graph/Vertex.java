package main.java.graph;

public record Vertex(String name) {

    @Override
    public String toString() {
        return name;
    }

}
