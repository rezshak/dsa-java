package main.java.queue;

// Left (front) to right (rear) linked list queue
class Queue<T> {

    private static class Node<T> {
        final T item;
        Node<T> next;

        Node(T item) {
            this.item = item;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    private Node<T> front, rear;
    private int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(T item) {
        var node = new Node<T>(item);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public T dequeue() {
        checkIfEmpty();
        T item = front.item;
        front = front.next;
        size--;
        return item;
    }

    public T peek() {
        checkIfEmpty();
        return front.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void checkIfEmpty() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[ ");
        var curr = front;
        while (curr != null) {
            sb.append(curr.item).append(" ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        var queue = new Queue<Integer>();
        System.out.println("size: " + queue.size());
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(7);
        System.out.println(queue);
        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println(queue);
    }

}
