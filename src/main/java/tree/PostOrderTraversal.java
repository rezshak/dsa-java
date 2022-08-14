package main.java.tree;

import java.util.Stack;

public final class PostOrderTraversal {

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node + " ");
    }

    public static void postorderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Stack<Integer> out = new Stack<>();

        while (!stack.empty()) {
            // pop a node from the stack and push the data into the output stack
            Node curr = stack.pop();
            out.push(curr.val);

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        while (!out.empty()) System.out.print(out.pop() + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("\nPost-order traversal recursive: ");
        postorder(root);

        System.out.println("\nPost-order traversal Iterative: ");
        postorderIterative(root);
    }

}
