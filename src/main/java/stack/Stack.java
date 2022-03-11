package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private int[] arr;
    private int ptr;
    private int min;

    Stack() {
        this(10);
    }

    Stack(int size) {
        arr = new int[size];
        ptr = 0;
        min = Integer.MAX_VALUE;
    }

    void push(int n) {
        resizeIfNeeded();
        setMin(n);
        arr[ptr++] = n;
    }

    int pop() {
        checkIfEmpty();
        int n = arr[--ptr];
        arr[ptr] = 0;
        return n;
    }

    int peek() {
        return arr[ptr - 1];
    }

    boolean empty() {
        return ptr == 0;
    }

    void printStack() {
        System.out.println("-----");
        for (int i = ptr - 1; i >= 0; i--)
            System.out.println("[ " + arr[i] + " ]");
    }

    @Override
    public String toString() {
        checkIfEmpty();
        var content = Arrays.copyOf(arr, ptr);
        return Arrays.toString(content);
    }

    private void checkIfEmpty() {
        if (ptr == 0) throw new EmptyStackException();
    }

    private void resizeIfNeeded() {
        if (ptr == arr.length) {
            var arr2 = new int[arr.length * 2];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
        }
    }

    int min() { return min; }

    private void setMin(int n) {
        if (ptr == 0) min = n;
        else min = Math.min(min, n);
    }

}
