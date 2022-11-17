package main.java;

class ListNode {
    final int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return val + " ";
    }
}
public class Solution {

    static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseLinkedList = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseLinkedList;
    }

    static void printLinkedList(ListNode head) {
        System.out.print("[ ");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr);
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printLinkedList(head);
        head = reverseLinkedList(head);
        printLinkedList(head);
    }
}
