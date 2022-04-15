package tree;

final class BinarySearchTree {

    static class Node {
        int value;
        Node left, right;
        Node(int value) {
            this.value = value;
            left = right = null;
        }
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = insertHelper(root, value);
    }

    Node insertHelper(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insertHelper(node.left, value);
        } else {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    void insertIterative(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node curr = root;
        while (true) {
            if (value < curr.value) {
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

    boolean find(int value) {
        return findHelper(root, value);
    }
    boolean findHelper(Node node, int target) {
        if (node == null) return false;
        if (target == node.value) return true;
        if (target < node.value) return findHelper(node.left, target);
        return findHelper(node.right, target);
    }
    boolean findIterative(int target) {
        Node curr = root;
        while (curr != null) {
            if (target == curr.value) return true;
            if (target < curr.value) curr = curr.left;
            else curr = curr.right;
        }
        return false;
    }

    void deleteValue(int value) {
        root = deleteValue(root, value);
    }
    Node deleteValue(Node root, int value) {
        if (root == null) return null;

        // Find the node to be deleted
        if (value < root.value) {
            root.left = deleteValue(root.left, value);
        } else if (value > root.value) {
            root.right = deleteValue(root.right, value);
        } else {
            // If the node is with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.value = min(root.right);

            // Delete the inorder successor
            root.right = deleteValue(root.right, root.value);
        }

        return root;
    }

    int height() {
        return height(root);
    }

    int height(Node node) {
        if (node == null) return -1;
        if (node.left == null && node.right == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    int min() {
        return min(root);
    }

    int min(Node node) {
        if (node == null) return 0;
        if (node.left == null) return node.value;
        return min(node.left);
    }

    int minIterative(Node node) {
        int min = node.value;
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
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

    void print(Node node) {
        System.out.println("Root: " + root);
        System.out.println("  Curr: " + node);
        System.out.println("  Left: " + node.left);
        System.out.println("  Right: " + node.right);
        System.out.println("  Height: " + height(node));
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(17);
        bst.insert(11);
        bst.insert(21);
        bst.insert(26);
        bst.insert(5);

//        bst.root = new Node(17);
//        bst.root.left = new Node(11);
//        bst.root.right = new Node(21);

        bst.preorder(bst.root);

        System.out.println(bst.find(14));

        System.out.println("height: " + bst.height());

        System.out.println("min iterative: " + bst.min());
        System.out.println("min: " + bst.min());

    }
}
