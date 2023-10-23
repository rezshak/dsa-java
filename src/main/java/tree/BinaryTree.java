package main.java.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

class BinaryTree {

    int heightRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var leftHeight = heightRecursive(root.left);
        var rightHeight = heightRecursive(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    int heightIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        var height = 0;
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null)
                    queue.add(node.right);
            }
            height++;
        }
        return height;
    }

    // Every parent node/internal node has either two or no children
    boolean isFullBinaryTree(TreeNode treeNode) {
        if (treeNode == null) return true;
        if (treeNode.left == null && treeNode.right == null) return true;
        if (treeNode.left != null && treeNode.right != null) {
            return isFullBinaryTree(treeNode.left) && isFullBinaryTree(treeNode.right);
        }
        return false;
    }

    int perfectBinaryTreeDepth(TreeNode treeNode) {
        int d = 0;
        while (treeNode != null) {
            d++;
            treeNode = treeNode.left;
        }
        return d;
    }

    // Every internal node has exactly two child nodes,
    // and all the leaf nodes are at the same level
    boolean isPerfectBinaryTree(TreeNode treeNode, int depth, int level) {
        if (treeNode == null) return true;
        if (treeNode.left == null && treeNode.right == null)
            return depth == level + 1;
        return isPerfectBinaryTree(treeNode.left, depth, level + 1) &&
                isPerfectBinaryTree(treeNode.right, depth, level + 1);
    }

    boolean isPerfectBinaryTree(TreeNode root) {
        int depth = perfectBinaryTreeDepth(root);
        return isPerfectBinaryTree(root, depth, 0);
    }

    int countNumNodes(TreeNode root) {
        if (root == null) return 0;
        return countNumNodes(root.left) + countNumNodes(root.right) + 1;
    }

    boolean isCompleteBinaryTree(TreeNode root) {
        int nodeCount = countNumNodes(root);
        return isCompleteBinaryTree(root, 0, nodeCount);
    }

    boolean isCompleteBinaryTree(TreeNode root, int index, int numberNodes) {
        if (root == null) return true;
        if (index >= numberNodes) return false;
        return isCompleteBinaryTree(root.left, 2 * index + 1, numberNodes) &&
                isCompleteBinaryTree(root.right, 2 * index + 2, numberNodes);
    }

    void printBinaryTree(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {

        var bt = new BinaryTree();
        var root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Height recursive: ");
        System.out.println(bt.heightRecursive(root));

        System.out.print("Height iterative: ");
        System.out.println(bt.heightRecursive(root));

        System.out.println();

        System.out.println("Full: " + bt.isFullBinaryTree(root));
        System.out.println("Perfect: " + bt.isPerfectBinaryTree(root));
        System.out.println("Complete: " + bt.isCompleteBinaryTree(root));
    }

}
