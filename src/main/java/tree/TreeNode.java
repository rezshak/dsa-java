package main.java.tree;

class TreeNode {

    final int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
