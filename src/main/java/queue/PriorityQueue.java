package queue;

import java.util.Arrays;

final class PriorityQueue {

    static final int INITIAL_CAPACITY = 5;
    int[] items;
    int count;

    PriorityQueue() {
        this(INITIAL_CAPACITY);
    }

    PriorityQueue(int capacity) {
        items = new int[capacity];
        count = 0;
    }

    // O(n)
    public void enqueue(int item) {
        if (isFull())
            throw new RuntimeException("Priority queue is full");

        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public boolean isFull() {
        return count == items.length;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    // O(1)
    public int dequeue() {
        if (isEmpty())
            throw new RuntimeException("Priority queue is empty");

        count--;
        int item = items[count];
        items[count] = 0;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
