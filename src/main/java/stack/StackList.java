package main.java.stack;

public class StackList {

    private class Node {
        final int item;
        Node prev;

        Node(int item) {
            this.item = item;
            prev = null;
        }
    }

    private Node top;
    private int count;

    public StackList() {
        top = null;
        count = 0;
    }

    public void push(int item) {
        Node node = new Node(item);
        node.prev = top;
        top = node;
        count++;
    }

    public int pop() {
        checkIfEmpty();
        int item = top.item;
        top = top.prev;
        return item;
    }

    public int peek() {
        checkIfEmpty();
        return top.item;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[ ");
        Node curr = top;
        while (curr != null) {
            sb.append(curr.item).append(" ");
            curr = curr.prev;
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("stack list empty");
        }
    }

    public static void main(String[] args) {
        var sl = new StackList();
        sl.push(3);
        sl.push(5);
        sl.push(7);
        System.out.println(sl);
        System.out.println("popped: " + sl.pop());
        System.out.println("peeked: " + sl.peek());
        System.out.println(sl);
        System.out.println("size: " + sl.size());
    }

}
