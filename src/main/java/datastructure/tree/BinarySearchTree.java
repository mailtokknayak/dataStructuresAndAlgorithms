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


    boolean isBST(Node root) {
        int max = maxOfLeft(root.left);
        int min = minOfRight(root.right);

        return root.data > max && root.data < min;
    }

    public int maxOfLeft(Node node) {
        int res = Integer.MIN_VALUE;
        if (node == null)
            return res;

        if (node.left != null)
            res = node.left.data;

        int maxSub = Math.max(maxOfLeft(node.left), maxOfLeft(node.right));
        return Math.max(res, maxSub);
    }

    public int minOfRight(Node node) {
        int res = Integer.MAX_VALUE;
        if (node == null)
            return res;
        if (node.right != null)
            res = node.right.data;

        int minSub = Math.min(minOfRight(node.left), minOfRight(node.right));
        return Math.min(res, minSub);
    }
}
