package main.java.list;

class Node {
    final int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}

public class ReverseLinkedList {

    static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        Node curr = head;
        System.out.print("[ ");
        while (curr != null) {
            System.out.print(curr);
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        printList(head);
        head = reverseList(head);
        printList(head);
    }

}
