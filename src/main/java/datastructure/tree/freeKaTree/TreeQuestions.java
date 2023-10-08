package datastructure.tree.freeKaTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeQuestions {

    public Node create(int[] array, int index) {

        Node root = null;
        if (index < array.length) {
            root = new Node(array[index]);

            root.left = create(array, 2 * index + 1);
            root.right = create(array, 2 * index + 2);
        }

        return root;
    }

    public Node preOrderR(Node node) {

        if (node == null)
            return null;
        System.out.print(node.data);
        preOrderR(node.left);
        preOrderR(node.right);

        return node;

    }

    public Node postOrderR(Node node) {
        if (node == null)
            return node;
        postOrderR(node.left);
        postOrderR(node.right);
        System.out.print(node.data);

        return node;
    }

    public Node inOrderR(Node node) {
        if (node == null)
            return null;

        inOrderR(node.left);
        System.out.print(node.data);
        inOrderR(node.right);

        return node;
    }

    public Node levelOrderR(Node node) {

        if (node == null)
            return null;

        Queue<Node> queue = new LinkedList<>();

        System.out.print(node.data);
        queue.add(node);
        Node temp = null;
        while (!queue.isEmpty()) {
            temp = queue.remove();
            if (temp.left != null) {
                System.out.print(temp.left.data);
                queue.add(temp.left);
            }
            if (temp.right != null) {
                System.out.print(temp.right.data);
                queue.add(temp.right);
            }

        }
        return node;
    }

    public Node preOrderI(Node node) {
        if (node == null)
            return null;

        Stack<Node> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return node;
    }

    public Node inOrderI(Node node) {
        if (node == null)
            return null;

        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data);
                node = node.right;
            }
        }
        return node;
    }

    public Node postOrderI(Node node) {
        if (node == null)
            return null;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }

        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data);
        }
        return node;
    }

    public Node buildTreeFromPreIn() {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        return buildHelper(0, 0, inOrder.length - 1, preOrder, inOrder);
    }

    private Node buildHelper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {

        if (preStart > preOrder.length - 1 || inStart > inEnd)
            return null;

        int inIndex = 0;
        Node root = new Node(preOrder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (root.data == inOrder[i])
                inIndex = i;
        }

        root.left = buildHelper(preStart + 1, inStart, inIndex - 1, preOrder, inOrder);
        root.right = buildHelper((preStart + inIndex - inStart + 1), inIndex + 1, inEnd, preOrder, inOrder);
        return root;
    }

    public int maxHeightBst(Node node) {
        if (node == null)
            return 0;
        int lh = maxHeightBst(node.left);
        int rh = maxHeightBst(node.right);

        return 1 + Math.max(lh, rh);

    }

    public int isTreeIsBalance(Node node) {
        if (node == null)
            return 0;
        int lh = maxHeightBst(node.left);
        int rh = maxHeightBst(node.right);
        if (lh == -1 || rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);

    }

    public class Node {
        private Node left = null;
        private Node right = null;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
