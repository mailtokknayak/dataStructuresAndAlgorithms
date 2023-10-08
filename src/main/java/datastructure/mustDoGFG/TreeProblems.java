package datastructure.mustDoGFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeProblems {
    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    static class Pair {
        int hd;
        Node node;

        public Pair(int val, Node node) {
            this.hd = val;
            this.node = node;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Node root1 = buildTree(s);
        TreeProblems g = new TreeProblems();
        System.out.println(">>" + g.height(root1));

    }

    public static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static boolean isBST(Node root) {
        // code here.
        if (root == null) return true;

        int maxOfLeft = maxOfLeftSide(root);
        int minOfRight = minOfRightSide(root);

        return root.data > maxOfLeft && root.data < minOfRight;
    }

    public static int maxOfLeftSide(Node root) {
        int max = Integer.MIN_VALUE;
        if (root == null) return max;
        if (root.left != null) max = root.left.data;

        int maxSub = Math.max(maxOfLeftSide(root.left), maxOfLeftSide(root.right));
        return Math.max(maxSub, max);
    }

    public static int minOfRightSide(Node root) {
        int min = Integer.MAX_VALUE;
        if (root == null) return min;

        if (root.right != null) min = root.right.data;

        int minSub = Math.min(minOfRightSide(root.left), minOfRightSide(root.right));

        return Math.min(min, minSub);
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;
        return isSys(root.left, root.right);
    }

    private static boolean isSys(Node left, Node right) {
        if (left == null || right == null)
            return left == right;
        if (left.data != right.data)
            return false;

        return isSys(left.left, right.right) && isSys(left.right, right.left);
    }

    public ArrayList<Integer> bottomView(Node root) {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (!map.containsKey(cur.hd)) {
                map.put(cur.hd, cur.node.data);
            }
            if (cur.node.left != null) queue.add(new Pair(cur.hd - 1, cur.node.left));

            if (cur.node.right != null) queue.add(new Pair(cur.hd + 1, cur.node.right));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    public ArrayList<Integer> findSpiral(Node root) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        boolean leftToRight = false;

        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node temp = q.poll();
                list.add(temp.data);

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
            if (!leftToRight)
                Collections.reverse(list);
            leftToRight = !leftToRight;
            result.addAll(list);
        }
        return result;
    }

    public void connect(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node pre = null;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node curr = queue.poll();
                if (pre != null) {
                    pre.nextRight = curr;
                }
                pre = curr;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            pre = null;
        }
    }

    Node LCA(Node root, int n1, int n2) {
        // code here.
        if (root.data == n1 || root.data == n2)
            return root;

        if (root.left == null && root.right == null)
            return null;

        Node left = null, right = null;
        if (root.left != null)
            left = LCA(root.left, n1, n2);
        if (root.right != null)
            right = LCA(root.right, n1, n2);
        if (left != null && right != null)
            return root;

        return left == null ? right : left;
    }

    int findLCA(Node root, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2, path1, path2);
    }

    private int findLCAInternal(Node root, int n1, int n2, List<Integer> path1, List<Integer> path2) {

        if (!findPath(root, n1, path1)
                || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0)
                    ? "n1 is present"
                    : "n1 is missing");
            System.out.println((path2.size() > 0)
                    ? "n2 is present"
                    : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size();
             i++) {

            // System.out.println(path1.get(i) + " " +
            // path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    // Finds the path from root node to given root of the
    // tree, Stores the path in a vector path[], returns
    // true if path exists otherwise false
    private boolean findPath(Node root, int n,
                             List<Integer> path) {
        // base case
        if (root == null) {
            return false;
        }

        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.data);

        if (root.data == n || findPath(root.left, n, path) || findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root,
        // remove root from path[] and return false
        path.remove(path.size() - 1);

        return false;
    }

    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return false;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1 = preOrderSearch(root1, list1);
        list2 = preOrderSearch(root2, list2);
        return list1.equals(list2);
    }

    private ArrayList<Integer> preOrderSearch(Node root, ArrayList<Integer> list) {
        if (root == null)
            return list;
        list.add(root.data);
        preOrderSearch(root.left, list);
        preOrderSearch(root.right, list);
        return list;
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        int x = height(node.left);
        int y = height(node.right);
        return Math.max(x, y) + 1;
    }

    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        int res = Integer.MIN_VALUE;
        return helper(root, res);
    }

    private int helper(Node root, int res) {
        if (root == null)
            return 0;

        int l = diameter(root.left);
        int r = diameter(root.right);

        int temp = Math.max(l, r) + 1;
        res = Math.max(l + r + 1, temp);
        return res;
    }

    public int countLeaves(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        int left = countLeaves(node.left);
        int right = countLeaves(node.right);

        return left + right;
    }

    public boolean isBalanced(Node root) {
        if (root == null)
            return true;
        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxHeight(Node node) {
        if (node == null)
            return 0;
        int left = maxHeight(node.left);
        int right = maxHeight(node.right);

        return 1 + Math.max(left, right);
    }

    public static String serialize(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);

        ArrayList<String> list = new ArrayList<>();
        while (!s.isEmpty()) {
            Node t = s.pop();
            if (t == null) {
                list.add("#");
            } else {
                list.add("" + t.data);
                s.push(t.right);
                s.push(t.left);
            }
        }
        return String.join(",", list);
    }

    static int t;

    public static Node deserialize(String data) {
        if (data == null)
            return null;
        t = 0;
        String[] arr = data.split(",");
        return helper(arr);
    }

    public static Node helper(String[] arr) {
        if (arr[t].equals("#"))
            return null;

        Node root = new Node(Integer.parseInt(arr[t]));
        t++;
        root.left = helper(arr);
        t++;
        root.right = helper(arr);
        return root;
    }
}