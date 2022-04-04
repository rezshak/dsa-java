package tree;

final class BinarySearchTree {

    class Node {
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

    BinarySearchTree() {
        root = null;
    }

    void insert(int item) {
        root = insertItem(root, item);
    }

    Node insertItem(Node root, int item) {
        if (root == null) {
            root = new Node(item);
            return root;
        }

        if (item < root.item)
            root.left = insertItem(root.left, item);
        else if (item > root.item)
            root.right = insertItem(root.right, item);

        return root;
    }

    void insertIterative(int item) {
        Node newNode = new Node(item);
        if (root == null) {
            root = newNode;
            return;
        }
        Node curr = root;
        while (true) {
            if (item < curr.item) {
                if (curr.left == null) {
                    curr.left = newNode;
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = newNode;
                    break;
                }
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(5);
        bst.insert(11);

        System.out.println(bst.root);

        System.out.println(Runtime.version());
    }
}
