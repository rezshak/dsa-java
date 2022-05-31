package tree;

import java.util.Stack;

public final class PreOrderTraversal {

    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void preorderIterative(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            Node curr = stack.pop();
            System.out.print(curr + " ");
            // Right child must be pushed first so that the left child is processed first (LIFO order)
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
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

        System.out.println("\nPre-order traversal recursive: ");
        preorder(root);

        System.out.println("\nPre-order traversal iterative: ");
        preorderIterative(root);
    }

}
