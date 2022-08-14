package main.java.tree;

final class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
