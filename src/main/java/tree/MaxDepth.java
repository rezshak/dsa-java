package tree;

public final class MaxDepth {

    public static int maxDepth(Node node) {
        if (node == null) return 0;
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);
        return Math.max(leftMax, rightMax) + 1;
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
        root.right.left.left.left = new Node(9);

        System.out.println("\nMax depth: ");
        System.out.println(maxDepth(root));
    }
}
