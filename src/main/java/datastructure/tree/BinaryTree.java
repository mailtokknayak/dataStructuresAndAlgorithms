package datastructure.tree;

import java.util.*;

public class BinaryTree {
    Node root;
    int pre = Integer.MIN_VALUE;

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public void createBST(int data) {

        Node node = new Node(data);

        if (root == null) {
            root = node;
            return;
        }
        String flag = "";
        while (root != null) {
            if (data > root.data) {
                root = root.right;
                flag = "right";
            } else if (data < root.data) {
                root = root.left;
                flag = "left";
            }
        }
        if (!flag.isEmpty()) {
            if (flag.equals("left"))
                root.left = node;
            else
                root.right = node;
        }

    }

    public Node createBinaryTree(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        int i = 1;
        while (i < n) {
            Node curr = queue.remove();
            if (i < n) {
                curr.left = new Node(arr[i++]);
                queue.add(curr.left);
            }
            if (i < n) {
                curr.right = new Node(arr[i++]);
                queue.add(curr.right);
            }
        }
        printTree(root);
        return root;
    }

    public Node createBinaryTreeR(int[] arr, int i) {
        int n = arr.length;
        Node root = null;
        if (i < n) {
            root = new Node(arr[i]);
            root.left = createBinaryTreeR(arr, 2 * i + 1);
            root.right = createBinaryTreeR(arr, 2 * i + 2);
        }
        return root;
    }

    public List<Integer> preOrder(Node root, List<Integer> list) {
        if (root == null)
            return list;
        list.add(root.data);
        preOrder(root.left, list);
        preOrder(root.right, list);

        return list;
    }

    public void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        return traversalHelper(root, result);
    }

    public List<Integer> traversalHelper(Node root, List<Integer> list) {
        if (root == null)
            return list;

        list.add(root.data);
        traversalHelper(root.left, list);
        traversalHelper(root.right, list);
        return list;
    }

    public List<Integer> inorderTraversal(Node root) {

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            list.add(node.data);
        }
        return list;
    }

    public List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return out;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        list.add(root.data);
        out.add(list);
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.remove();
                if (curr != null) {
                    if (curr.left != null) {
                        queue.add(curr.left);
                        list.add(curr.left.data);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                        list.add(curr.right.data);
                    }
                }
            }
            if (list.size() > 0)
                out.add(list);

        }

        return out;
    }

    public boolean isSymmetric(Node root) {
        if (root == null)
            return true;
        return isSym(root.left, root.right);
    }

    private boolean isSym(Node left, Node right) {
        if (left == null || right == null)
            return left == right;
        if (left.data != right.data)
            return false;
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }

    public boolean pathSum(Node root, int pathSum) {
        if (root == null)
            return false;
        else if (root.left == null && root.right == null && pathSum - root.data == 0)
            return true;
        else
            return pathSum(root.left, pathSum - root.data) || pathSum(root.right, pathSum - root.data);
    }

    public Node buildTree(int[] preorder, int[] inorder) {
        int ps = 0;
        int pe = preorder.length - 1;
        int is = 0;
        int ie = inorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = is; i <= ie; i++) {
            map.put(inorder[i], i);
        }
        return treeHelper(preorder, inorder, ps, pe, is, ie, map);
    }

    private Node treeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie)
            return null;

        Node root = new Node(preorder[ps]);
        int index = map.get(preorder[ps]);

        root.left = treeHelper(preorder, inorder, ps - is + index + 1, pe, is, index - 1, map);
        root.right = treeHelper(preorder, inorder, ps - is + index + 1, pe, index + 1, ie, map);

        return root;
    }

    public boolean isBst(Node root) {
        return isBstUtils(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBstUtils(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;

        if (root.data <= minValue || root.data >= maxValue)
            return false;
        return isBstUtils(root.left, minValue, root.data - 1) && isBstUtils(root.right, root.data + 1, maxValue);
    }

    public boolean isBstM2(Node root) {
        if (root == null)
            return true;

        if (!isBstM2(root.left))
            return false;
        if (root.data <= pre)
            return false;
        pre = root.data;
        return isBstM2(root.right);
    }


}
