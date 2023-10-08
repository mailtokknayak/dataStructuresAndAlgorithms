package datastructure.tree;

public class BinarySearchTree {

    public boolean isBstM1(Node root) {
        return bstUtils(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean bstUtils(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.data < minValue || root.data > maxValue)
            return false;
        return bstUtils(root.left, minValue, root.data - 1) && bstUtils(root.right, root.data + 1, maxValue);
    }

    public boolean isBstM2(Node root) {
        return bstUtils(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
