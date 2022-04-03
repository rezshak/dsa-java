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
        work(node);
        preorder(node.left);
        preorder(node.right);
    }

    // lnr
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        work(node);
        inorder(node.right);

    }

    // lrn
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        work(node);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(5);

        System.out.println("\nInorder traversal");
        tree.inorder(tree.root);

        System.out.println("\nPreorder traversal");
        tree.preorder(tree.root);

        System.out.println("\nPostorder traversal");
        tree.postorder(tree.root);
    }

    private static void work(Node node) {
        System.out.println(node);
    }

}
