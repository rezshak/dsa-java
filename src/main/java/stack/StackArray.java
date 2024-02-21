package main.java.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArray {

    private static final int CAP = 10;

    private int[] items;
    private int top;

    public StackArray() {
        this(CAP);
    }

    public StackArray(int cap) {
        items = new int[cap];
        top = 0;
    }

    public void push(int item) {
        resizeIfNeeded();
        items[top++] = item;
    }

    public int pop() {
        checkIfEmpty();
        int item = items[--top];
        items[top] = 0;
        return item;
    }

    public int peek() {
        checkIfEmpty();
        return items[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < top; i++) {
            sb.append(items[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    private void resizeIfNeeded() {
        if (top >= items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    public static void main(String[] args) {
        var sa = new StackArray(3);
        System.out.println(sa);
        System.out.println("empty: " + sa.isEmpty());
        System.out.println("size: " + sa.size());
        sa.push(3);
        sa.push(4);
        sa.push(5);
        System.out.println(sa);
        System.out.println("empty: " + sa.isEmpty());
        System.out.println("peek: " + sa.peek());
        System.out.println("pop: " + sa.pop());
        System.out.println(sa);
        System.out.println("size: " + sa.size());
        sa.push(6);
        sa.push(7);
        System.out.println(sa);
    }

}
