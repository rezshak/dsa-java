package main.java.list;

class ListNode {
    final int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}

public class ReverseLinkedList {

    // 1 -> 2 -> 3 -> 4 -> 5
    // 5 -> 4 -> 3 -> 2 -> 1
    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    // 5 -> 4 -> 3 -> 2 -> 1
    static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode reversedListHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListHead;
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    // 1 -> 4 -> 3 -> 2 -> 5
    static ListNode reversePartialList(ListNode head, ListNode start, ListNode end) {
        if (head == null) {
            return null;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        // Find partial list's previous node
        ListNode startPrev = fake;
        while (startPrev.next != null && startPrev.next != start) {
            startPrev = startPrev.next;
        }
        // Find partial list's next node
        ListNode endNext = end.next;
        // Reverse the partial sublist
        ListNode prev = endNext, curr = start;
        while (curr != endNext) {
            var tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        // Reconnect
        startPrev.next = prev;
        return fake.next;
    }

    private static void printList(ListNode head) {
        var sb = new StringBuilder();
        sb.append("[ ");
        var curr = head;
        while (curr != null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        printList(head1);
        // head1 = reverseList(head1);
        // printList(head1);

        var partialHead1 = reversePartialList(head1, head1.next, head1.next.next.next);
        printList(partialHead1);
    }

}
