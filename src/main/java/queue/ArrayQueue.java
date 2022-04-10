package queue;

import java.util.Arrays;

final class ArrayQueue {

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
        if (isFull())
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        int item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;

        return item;
    }

    int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[front];
    }

    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
