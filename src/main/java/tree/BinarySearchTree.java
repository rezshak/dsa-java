package tree;

final class BinarySearchTree {

    static class Node {
        int key;
        Node left, right;
        Node(int key) {
            this.key = key;
            left = right = null;
        }
        @Override
        public String toString() {
            return "Node: " + key;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    Node insertKey(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key) {
            node.left = insertKey(node.left, key);
        } else if (key > node.key) {
            node.right = insertKey(node.right, key);
        }
        return node;
    }

    void insertIterative(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Node curr = root;
        while (true) {
            if (key < curr.key) {
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

    Node search(int key) {
        return search(root, key);
    }
    private Node search(Node node, int key) {
        if (node == null) return null;
        if (key == node.key) return node;
        if (key < node.key) return search(node.left, key);
        return search(node.right, key);
    }

    void deleteKey(int key) {
        root = deleteKey(root, key);
    }
    Node deleteKey(Node root, int key) {
        if (root == null) return null;

        // Find the node to be deleted
        if (key < root.key) {
            root.left = deleteKey(root.left, key);
        } else if (key > root.key) {
            root.right = deleteKey(root.right, key);
        } else {
            // If the node is with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.key = min(root.right);

            // Delete the inorder successor
            root.right = deleteKey(root.right, root.key);
        }

        return root;
    }

    int min(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
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
        System.out.println(node.key);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.root = new Node(15);
        bst.root.left = new Node(12);
        bst.root.right = new Node(21);

//        bst.postorder(bst.root);

        Node found = bst.search(bst.root, 14);
        System.out.println(found == null ? "Not Found" : "Found " + found);

        System.out.println("Root " + bst.root);
    }
}
