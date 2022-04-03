package tree;

final class BinaryTree {

    static class Node {
        int item;
        Node left, right;

        Node(int item) {
            this.item = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node: " + item;
        }
    }

    Node root;

    BinaryTree() {
        root = null;
    }

    // nlr
    void preorder(Node node) {
        if (node == null) return;
        print(node);
        preorder(node.left);
        preorder(node.right);
    }

    // lnr
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        print(node);
        inorder(node.right);

    }

    // lrn
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        print(node);
    }

    // Every parent node/internal node has either two or no children
    boolean isFullBinaryTree(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }
        return false;
    }

    int perfectBinaryTreeDepth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    // Every internal node has exactly two child nodes,
    // and all the leaf nodes are at the same level
    boolean isPerfectBinaryTree(Node node, int depth, int level) {
        if (node == null) return true;
        if (node.left == null && node.right == null)
            return depth == level + 1;
        return isPerfectBinaryTree(node.left, depth, level + 1) &&
                isPerfectBinaryTree(node.right, depth, level + 1);
    }

    boolean isPerfectBinaryTree(Node root) {
        int depth = perfectBinaryTreeDepth(root);
        return isPerfectBinaryTree(root, depth, 0);
    }


    int countNumNodes(Node root) {
        if (root == null) return 0;
        return countNumNodes(root.left) + countNumNodes(root.right) + 1;
    }

    boolean isCompleteBinaryTree(Node root) {
        int nodeCount = countNumNodes(root);
        return isCompleteBinaryTree(root, 0, nodeCount);
    }

    boolean isCompleteBinaryTree(Node root, int index, int numberNodes) {
        if (root == null) return true;
        if (index >= numberNodes) return false;
        return isCompleteBinaryTree(root.left, 2 * index + 1, numberNodes) &&
                isCompleteBinaryTree(root.right, 2 * index + 2, numberNodes);
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);

        bt.root.left = new Node(12);
        bt.root.right = new Node(9);

        bt.root.left.left = new Node(5);
        bt.root.left.right = new Node(6);

        bt.root.right.left = new Node(14);
        bt.root.right.right = new Node(15);

        System.out.println("\nInorder traversal");
        bt.inorder(bt.root);

        System.out.println("\nPreorder traversal");
        bt.preorder(bt.root);

        System.out.println("\nPostorder traversal");
        bt.postorder(bt.root);

        System.out.println("Full: " + bt.isFullBinaryTree(bt.root));
        System.out.println("Perfect: " + bt.isPerfectBinaryTree(bt.root));
        System.out.println("Complete: " + bt.isCompleteBinaryTree(bt.root));
    }

    private static void print(Node node) {
        System.out.println(node);
    }

}
