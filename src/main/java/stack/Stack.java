package stack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

public class Stack {

    static final int CAPACITY = 10;
    int[] items;
    int count;

    public Stack() {
        this(CAPACITY);
    }

    Stack(int capacity) {
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
        Stack st = new Stack();
        st.push(7);
        System.out.println(st.pop());
        st.push(3);
        st.push(4);
        System.out.println("size: " + st.size());
        System.out.println(st);
        System.out.println("peek: " + st.peek());
        System.out.println("pop: " + st.pop());
        st.print();

        JUnitCore.main("stack.Stack");
    }

    Stack st = null;

    @Before
    public void setup() {
        st = new Stack();
    }

    @Test
    public void push1() {
        assertEquals(0, st.size());
        st.push(7);
        st.push(3);
        assertEquals(2, st.size());
    }

    @Test
    public void peek1() {
        assertEquals(0, st.size());
        st.push(7);
        st.push(3);
        assertEquals(2, st.size());
        assertEquals(3, st.peek());
        assertEquals(2, st.size());
    }

    @Test
    public void pop1() {
        st.push(7);
        st.push(3);
        assertEquals(3, st.pop());
        assertEquals(1, st.size());
    }

    @Test(expected = EmptyStackException.class)
    public void pop2_emptyStack() {
        assertEquals(0, st.size());
        st.pop();
    }

}
