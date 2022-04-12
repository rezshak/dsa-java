package queue;

import java.util.*;

final class StackQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    StackQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    void enqueue(int item) {
        st1.push(item);
    }

    int dequeue() {
        moveSt1ToSt2();
        return st2.pop();
    }

    boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }
    
    int peek() {
        moveSt1ToSt2();
        return st2.peek();
    }

    private void moveSt1ToSt2() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        if (st2.isEmpty()) {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
    }

    @Override
    public String toString() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        return st2.toString();
    }

    void print() {
        st1.forEach(item -> System.out.print(item + " "));
    }

}
