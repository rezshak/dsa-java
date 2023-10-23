package main.java.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

    // nlr
    void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void preorderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr + " ");
            // Right child must be pushed first so that the left child is processed first (LIFO order)
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    // lnr
    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root + " ");
        inorder(root.right);
    }

    void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

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

    // lrn
    void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root + " ");
    }

    void postorderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<Integer> out = new Stack<>();

        while (!stack.empty()) {
            // pop a node from the stack and push the data into the output stack
            TreeNode curr = stack.pop();
            out.push(curr.val);

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        while (!out.empty()) System.out.print(out.pop() + " ");
    }

    void levelOrder(TreeNode root) {
        int level = 1;
        while (levelOrder(root, level)) level++;
    }

    boolean levelOrder(TreeNode treeNode, int level) {
        if (treeNode == null) return false;
        if (level == 1) {
            System.out.print(treeNode + " ");
            return true;
        }
        boolean left = levelOrder(treeNode.left, level - 1);
        boolean right = levelOrder(treeNode.right, level - 1);
        return left || right;
    }

    void levelOrderIterative(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public static void main(String[] args) {

        var tr = new Traversal();

        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println("\nPre-order traversal recursive: ");
        tr.preorder(root);

        System.out.println("\nPre-order traversal iterative: ");
        tr.preorderIterative(root);

        System.out.println("\nIn-order traversal recursive: ");
        tr.inorder(root);

        System.out.println("\nIn-order traversal iterative: ");
        tr.inorderIterative(root);

        System.out.println("\nPost-order traversal recursive: ");
        tr.postorder(root);

        System.out.println("\nPost-order traversal Iterative: ");
        tr.postorderIterative(root);

        System.out.println("\nLevel order traversal recursive: ");
        tr.levelOrder(root);

        System.out.println("\nLevel order traversal iterative: ");
        tr.levelOrderIterative(root);
    }

}
