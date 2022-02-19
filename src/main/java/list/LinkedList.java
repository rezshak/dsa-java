package list;

import java.util.NoSuchElementException;
import java.util.Stack;

class LinkedList {

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;
    
    LinkedList() {
        head = tail = null;
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = tail = node;
        }
        size++;
    }

    void deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Node tempHead = head.next;
        if (hasOneNode()) {
            head = tail = null;
        } else {
            head.next = null;
            head = tempHead;
        }
        size--;
    }

    void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (hasOneNode()) {
            head = tail = null;
            return;
        }
        Node prev = getPrevious(tail);
        prev.next = null;
        tail = prev;
        size--;
    }

    Node getPrevious(Node node) {
        if (isEmpty()) throw new NoSuchElementException();
        Node curr = head;
        while (curr.next != null) {
            if (curr.next == node) return curr;
            curr = curr.next;
        }
        return null;
    }

    int indexOf(int value) {
        int index = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) return index;
            index++;
            curr = curr.next;
        }
        return -1;
    }

    boolean contains(int value) {
        return indexOf(value) != -1;
    }

    int size() { return size; }

    void print() {
        System.out.println("------------------------------");
        if (isEmpty()) return;
        System.out.println("Head: " + head + " : " + head.value);
        Node curr = head;
        while (curr != null) {
            System.out.println(curr + " : " + curr.value);
            curr = curr.next;
        }
        System.out.println("Tail: " + tail + " : " + tail.value);
        System.out.println("Size: " + size);
    }

    int[] toArray() {
        if (isEmpty()) throw new NoSuchElementException();
        int[] array = new int[size];
        int index = 0;
        Node curr = head;
        while (curr != null) {
            array[index++] = curr.value;
            curr = curr.next;
        }
        return array;
    }

    void reverse() {
        if (isEmpty() || hasOneNode()) return;
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = head;
        tail.next = null;
        head = prev;
    }

    int kthValueFromEnd(int k) {
        if (isEmpty() || k > size || k <= 0) throw new NoSuchElementException();
        Node curr = head;
        for (int i = 0; i < size - k; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    private boolean isEmpty() { return head == null; }

    private boolean hasOneNode() { return head == tail; }

}
