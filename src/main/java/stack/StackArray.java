package main.java.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

class StackArray {

    static final int CAPACITY = 10;
    int[] items;
    int count;

    public StackArray() {
        this(CAPACITY);
    }

    StackArray(int capacity) {
        items = new int[capacity];
        count = 0;
    }

    void push(int n) {
        checkIfFull();
        items[count++] = n;
    }

    int pop() {
        checkIfEmpty();
        int n = items[--count];
        items[count] = 0;
        return n;
    }

    int peek() {
        return items[count - 1];
    }

    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == items.length;
    }

    int size() {
        return count;
    }

    void print() {
        System.out.println("-----");
        for (int i = count - 1; i >= 0; i--)
            System.out.println("[ " + items[i] + " ]");
    }

    @Override
    public String toString() {
        checkIfEmpty();
        int[] content = Arrays.copyOf(items, count);
        return Arrays.toString(content);
    }

    private void checkIfFull() {
        if (isFull()) throw new StackOverflowError();
    }

    private void checkIfEmpty() {
        if (isEmpty()) throw new EmptyStackException();
    }

    public static void main(String[] args) {
        StackArray st = new StackArray();
        st.push(7);
        System.out.println(st.pop());
        st.push(3);
        st.push(4);
        System.out.println("size: " + st.size());
        System.out.println(st);
        System.out.println("peek: " + st.peek());
        System.out.println("pop: " + st.pop());
        st.print();

    }

}
