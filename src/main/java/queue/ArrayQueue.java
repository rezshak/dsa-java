package main.java.queue;

import java.util.Arrays;

class ArrayQueue {

    static final int INITIAL_CAPACITY = 5;

    int[] items;
    int rear, front, count;

    ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    ArrayQueue(int capacity) {
        items = new int[capacity];
        rear = front = count = 0;
    }

    void enqueue(int item) {
        resizeIfNeeded();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Array queue is empty");
        int item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    int peek() {
        if (isEmpty()) throw new IllegalStateException("Array queue is empty");
        return items[front];
    }

    boolean isEmpty() {
        return count == 0;
    }

    void resizeIfNeeded() {
        if (count == items.length) {
            int[] items2 = new int[items.length * 2];
            int curr = front;
            for (int i = 0; i < items.length; i++) {
                items2[i] = items[curr];
                curr = (curr + 1) % items.length;
            }
            front = 0;
            rear = items.length;
            items = items2;
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0, curr = front; i < count; i++, curr++) {
            sb.append(items[curr]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        var aq = new ArrayQueue(2);
        aq.enqueue(3);
        aq.enqueue(4);
        aq.enqueue(5);
        System.out.println(aq);
        var item = aq.dequeue();
        System.out.println(aq);
    }

}
