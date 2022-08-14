package main.java.tree;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderTraversal {

    public static void levelOrder(Node root) {
        int level = 1;
        while (levelOrder(root, level)) level++;
    }

    private static boolean levelOrder(Node node, int level) {
        if (node == null) return false;
        if (level == 1) {
            System.out.print(node + " ");
            return true;
        }
        boolean left = levelOrder(node.left, level - 1);
        boolean right = levelOrder(node.right, level - 1);
        return left || right;
    }

    static void levelOrderIterative(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
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

        System.out.println("\nLevel order traversal recursive: ");
        levelOrder(root);

        System.out.println("\nLevel order traversal iterative: ");
        levelOrderIterative(root);
    }

}
