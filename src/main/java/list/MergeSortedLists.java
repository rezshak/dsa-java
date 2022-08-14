package main.java.list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedLists {

    ListNode mergeSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        head.next = mergeSortedLists(list1, list2);
        return head;
    }

    ListNode mergeSortedListsIterative(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return head.next;
    }

    ListNode mergeSortedListsIterative2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(-99);
        ListNode tail = dummy;
        while (true) {
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        return dummy.next;
    }

    void printLinkedList(ListNode head) {
        System.out.print("> ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("<");
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(10);

        ListNode list2 = new ListNode(-1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        MergeSortedLists ml = new MergeSortedLists();

        ListNode merged1 = ml.mergeSortedListsIterative(list1, list2);
        ml.printLinkedList(merged1);

//        ListNode merged2 = ml.mergeSortedLists(list1, list2);
//        ml.printLinkedList(merged2);
    }

}
