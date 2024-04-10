package main.java.queue;

class CircularQueue {

    private static final int CAP = 5;
    private int[] items;
    private int front, rear, size;

    public CircularQueue() {
        this(CAP);
    }

    public CircularQueue(int cap) {
        items = new int[cap];
        front = rear = size;
    }

    public void enqueue(int item) {
        resizeIfNeeded();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        size++;
    }

    public int dequeue() {
        checkIfEmpty();
        int item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        size--;
        return item;
    }

    public int peek() {
        checkIfEmpty();
        return items[front];
    }

    public int size() {
        return size;
    }

    private void resizeIfNeeded() {
        if (size == items.length) {
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

    private void checkIfEmpty() {
        if (size == 0) {
            throw new RuntimeException("Circular queue is empty");
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(items[(front + i) % items.length]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        var cq = new CircularQueue(3);
        cq.enqueue(3);
        cq.enqueue(5);
        cq.enqueue(7);
        System.out.println(cq);
        cq.enqueue(8); // resized
        System.out.println(cq);
        System.out.println("peek: " + cq.peek());
        System.out.println("size: " + cq.size);
        System.out.println("dequeue: " + cq.dequeue());
        System.out.println(cq);
    }

}
