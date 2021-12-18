package tree;

final class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                "}";
    }
}

final class BST {

    Node root;

    void insert(int val) {

        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
        } else {
            Node curr = root;
            while (true) {
                if (curr.val > val) {
                    if (curr.left == null) {
                        curr.left = newNode;
                        return;
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = newNode;
                        return;
                    }
                    curr = curr.right;
                }
            }
        }
    }

    boolean lookup(int val) {

        if (root == null) {
            return false;
        }

        Node curr = root;

        while (curr != null) {
            if (curr.val == val) {
                return true;
            }
            if (curr.val > val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return false;
    }

    void remove(int val) {

        if (root == null) {
            return;
        }

        Node curr = root;
        Node prev = null;

        while (curr != null) {
            if (curr.val == val) {
                if (curr.left == null && curr.right == null) {
                    curr = null;
                } else if (curr.left == null) {
                    prev.right = curr.right;
                    curr = null;
                } else if (curr.right == null) {
                    prev.left = curr.left;
                    curr = null;
                }
            } else if (curr.val > val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }
    }

    public static void main(String... args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(11);
        bst.insert(3);
        bst.insert(4);

        System.out.println(bst.root);
        System.out.println(bst.lookup(11));
        bst.remove(1);
        System.out.println(bst.root);

    }

}
