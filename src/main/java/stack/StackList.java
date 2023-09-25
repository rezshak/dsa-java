package main.java.stack;

class StackList {

    private static class Node {
        int val;
        Node prev;
        Node(int val) {
            this.val = val;
            prev = null;
        }
    }

    Node tail;
    int count;

    StackList() {
        tail = null;
        count = 0;
    }

    public void push(int val) {
        Node node = new Node(val);
        node.prev = tail;
        tail = node;
        count++;
    }

    public int peek() {
        checkIfEmpty();
        return tail.val;
    }

    public void pop() {
        checkIfEmpty();
        tail = tail.prev;
        count--;
    }

    public void printStack() {
        checkIfEmpty();
        System.out.println("Stack (top-down):");
        Node curr = tail;
        while (curr != null) {
            System.out.printf("\t %d \n", curr.val);
            curr = curr.prev;
        }
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return count;
    }

    private void checkIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public static void main(String[] args) {

        var st = new StackList();
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);

        st.printStack();

        System.out.printf("\nTop element is %d\n", st.peek());

        st.pop();
        st.pop();

        st.printStack();

        System.out.printf("\nTop element is %d\n", st.peek());
    }

}
