package main.java;

import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node construct(int[] keys) {
        Node fake = new Node(-1);
        Node tail = fake;
        for (int n : keys) {
            tail.next = new Node(n);
            tail = tail.next;
        }
        return fake.next;
    }

    private static void printList(Node head) {
        System.out.print("[ ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null ]");
    }

    static String getString(Node head) {
        StringBuilder sb = new StringBuilder();
        sb.append("List: [ ");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        sb.append("null ]");
        return sb.toString();
    }

    static Node getMiddleNode(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node sortedInsert(Node head, Node node) {
        if (head == null) return node;
        Node fake = new Node(-1);
        fake.next = head;
        Node curr = fake;
        while (curr.next != null && curr.next.data < node.data) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        return fake.next;
    }

    public static Node shuffleMerge(Node X, Node Y) {
        Node fake = new Node(-1);
        Node tail = fake;
        while (true) {
            if (X == null) {
                tail.next = Y;
                break;
            } else if (Y == null) {
                tail.next = X;
                break;
            } else {
                tail.next = X;
                tail = X;
                X = X.next;
                tail.next = Y;
                tail = Y;
                Y = Y.next;
            }
        }
        return fake.next;
    }

    public static Node removeDuplicates(Node head)
    {
        if (head == null || head.next == null) return head;
        Set<Integer> seen = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (!seen.contains(curr.data)) {
                seen.add(curr.data);
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next = new Node(1);
//        head.next.next.next.next.next.next.next = new Node(3);
        removeDuplicates(head);
        printList(head);
    }

}
