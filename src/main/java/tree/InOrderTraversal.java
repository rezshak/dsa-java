package main.java.tree;

import java.util.Stack;

public final class InOrderTraversal {

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node + " ");
        inorder(node.right);
    }

    public static void inorderIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        Node curr = node;

        while (!stack.empty() || curr != null) {
            // If current node exists, push it into the stack (defer it) and move to its left child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // Otherwise, pop/print an element from the stack and set the current node to its right child
                curr = stack.pop();
                System.out.print(curr + " ");
                curr = curr.right;
            }
        }
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

        System.out.println("\nIn-order traversal recursive: ");
        inorder(root);

        System.out.println("\nIn-order traversal iterative: ");
        inorderIterative(root);
    }

}
