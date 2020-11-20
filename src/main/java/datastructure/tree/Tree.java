package datastructure.tree;

import datastructure.mustDoGFG.arrays.TreeProblems;

import java.util.*;

public class Tree {

    Node rootNode;
    List<Integer> listOfData = new ArrayList<>();

    public class Node {
        Node lChild;
        Node rChild;
        int data;

        Node(int data) {
            this.data = data;
            lChild = null;
            rChild = null;
        }
    }

    public void create() {
        Node p, t;
        Queue<Node> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Root Element");
        int root = scanner.nextInt();
        rootNode = new Node(root);
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            p = queue.remove();
            System.out.println("Enter Left child of " + p.data);
            int left = scanner.nextInt();

            if (left != -1) {
                t = new Node(left);
                p.lChild = t;
                queue.add(t);
            }
            System.out.println("Enter Right child of " + p.data);
            int right = scanner.nextInt();

            if (right != -1) {
                t = new Node(right);
                p.rChild = t;
                queue.add(t);
            }


        }


//        System.out.println(" is bst " + isBst(rootNode));
//        System.out.println("Pre order");
//        preOrderI(rootNode);
//        System.out.println("post order");
//        postOrder(rootNode);
//        System.out.println("in order");
//        inOrder(rootNode);
//
//        System.out.println("Level Traversal");
//        levelTraversal();
//
//        System.out.println("count" + count(rootNode));
//
////        System.out.println("preorderTravelList" + preorderTravelListI(rootNode));
//        System.out.println("postorderTravelListI" + postOrderTravelListI(rootNode));
//        System.out.println("maxDepth" + maxDepth(rootNode));

//        TreeProblems treeProblems = new TreeProblems();
        printVerticalTreeTravel(rootNode);

    }

    public void preOrder(Node rootNode) {
        if (rootNode == null) return;
        System.out.println("" + rootNode.data);
        preOrder(rootNode.lChild);
        preOrder(rootNode.rChild);
    }

    public void postOrder(Node rootNode) {
        if (rootNode == null) return;
        preOrder(rootNode.lChild);
        preOrder(rootNode.rChild);
        System.out.println("" + rootNode.data);

    }

    public void inOrder(Node rootNode) {
        if (rootNode == null) return;
        preOrder(rootNode.lChild);
        System.out.println("" + rootNode.data);
        preOrder(rootNode.rChild);

    }

    public void preOrderI(Node rootNode) {
        Stack<Node> stack = new Stack();
        while (rootNode != null || !stack.isEmpty()) {
            if (rootNode != null) {
                System.out.println("" + rootNode.data);
                stack.push(rootNode);
                rootNode = rootNode.lChild;
            } else {
                rootNode = stack.pop();
                rootNode = rootNode.rChild;
            }
        }
    }

    public List<List<Integer>> levelTraversal() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        if (rootNode == null) return list;
        Queue<Node> queue = new LinkedList<>();
        Node p = rootNode;
        subList.add(p.data);
        queue.add(p);
        list.add(subList);
        while (!queue.isEmpty()) {
            subList = new ArrayList<>();
            p = queue.remove();
            if (p.lChild != null) {
                subList.add(p.lChild.data);
                queue.add(p.lChild);
            }
            if (p.rChild != null) {
                subList.add(p.rChild.data);
                queue.add(p.rChild);
            }
        }

        return list;
    }

    public int count(Node rootNode) {
        int x, y;
        if (rootNode != null) {
            x = count(rootNode.lChild);
            y = count(rootNode.rChild);
            if (rootNode.rChild != null && rootNode.lChild != null)
                return x + y + 1;
        }
        return 0;
    }

    public List<Integer> preorderTravelList(Node rootNode) {
        if (rootNode != null) {
            listOfData.add(rootNode.data);
            preorderTravelList(rootNode.lChild);
            preorderTravelList(rootNode.rChild);
        }
        return listOfData;
    }

    public List<Integer> preorderTravelListI(Node rootNode) {
        Stack<Node> stack = new Stack<>();
        while (rootNode != null || !stack.isEmpty()) {
            if (rootNode != null) {
                listOfData.add(rootNode.data);
                stack.push(rootNode);
                rootNode = rootNode.lChild;
            } else {
                rootNode = stack.pop();
                rootNode = rootNode.rChild;
            }
        }
        return listOfData;
    }

    public List<Integer> postOrderTravelListI(Node root) {
        Node current = root;
        Deque<Node> stack = new LinkedList<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.addFirst(current);
                current = current.lChild;
            } else {
                Node temp = stack.peek().rChild;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.data + " ");
                    listOfData.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().rChild) {
                        temp = stack.poll();
                        listOfData.add(temp.data);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return listOfData;
    }

    public int maxDepth(Node root) {
        int ans = 0;
        if (root == null) return ans;
        int left_depth = maxDepth(root.lChild);
        int right_depth = maxDepth(root.rChild);
        return Math.max(left_depth, right_depth) + 1;
    }

    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        if (root.lChild == null || root.rChild == null)
            return false;
        if (root.lChild.data != root.rChild.data)
            return false;
        boolean left = isSymmetric(root.lChild);
        boolean right = isSymmetric(root.rChild);
        return left && right;
    }

    public Boolean isBst(Node rootNode) {
        if (rootNode == null) return true;

        int lmax = maxOfLeftSide(rootNode.lChild);
        System.out.println("left data" + lmax);
        int rMin = minOfRightSide(rootNode.rChild);
        System.out.println("right data" + rMin);

        return rootNode.data > lmax && rootNode.data < rMin;


    }

    public int maxOfLeftSide(Node rootNode) {
        int res = Integer.MIN_VALUE;
        if (rootNode == null)
            return res;

        if (rootNode.lChild != null)
            res = rootNode.lChild.data;

        int maxSub = Math.max(maxOfLeftSide(rootNode.lChild), maxOfLeftSide(rootNode.rChild));
        return Math.max(maxSub, res);
    }

    public int minOfRightSide(Node root) {
        int res = Integer.MAX_VALUE;
        if (root == null) return res;

        if (root.rChild != null)
            res = root.rChild.data;

        int maxSub = Math.min(minOfRightSide(root.lChild), minOfRightSide(root.rChild));

        return Math.min(maxSub, res);
    }
//    public Node treeFromPreInOrder(int[] preorder , int[] inorder){
//        if(preorder.length == 0 || inorder.length == 0) return null;
//        Node root = new Node(preorder[0]);
//        for(int i=0;i< preorder.length-1;i++){
//          for (int j=0;j<inorder.length-1;j++){
//             if( preorder[i] == inorder[j])
//
//          }
//        }
//
//        return null;
//    }

//    static void getVerticalOrder(Node root, int hd,
//                                 TreeMap<Integer, ArrayList<Integer>> m) {
//        // Base case
//        if (root == null)
//            return;
//
//        //get the vector list at 'hd'
//        ArrayList<Integer> get = m.get(hd);
//
//        // Store current node in map 'm'
//        if (get == null) {
//            get = new ArrayList<>();
//            get.add(root.data);
//        } else
//            get.add(root.data);
//
//        m.put(hd, get);
//
//        // Store nodes in left subtree
//        getVerticalOrder(root.lChild, hd - 1, m);
//
//        // Store nodes in right subtree
//        getVerticalOrder(root.rChild, hd + 1, m);
//    }
//
//    // The main function to print vertical order of a binary tree
//    // with the given root
//    static void printVerticalOrder(Node root) {
//        // Create a map and store vertical order in map using
//        // function getVerticalOrder()
//        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
//        int hd = 0;
//        getVerticalOrder(root, hd, m);
//
//        // Traverse the map and print nodes at every horigontal
//        // distance (hd)
//        for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
//            System.out.println(entry.getValue());
//        }
//    }

    public void printVerticalTreeTravel(Node rootNode) {

        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap();
        int hd = 0;

        verticalTreeTravel(rootNode, treeMap, hd);

        for (Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet())
            System.out.println(entry.getValue());

    }

    private void verticalTreeTravel(Node rootNode, TreeMap<Integer, ArrayList<Integer>> treeMap, int hd) {
        if (rootNode == null) return;

        ArrayList<Integer> list = treeMap.get(hd);

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(rootNode.data);

        treeMap.put(hd, list);

        verticalTreeTravel(rootNode.lChild, treeMap, hd - 1);
        verticalTreeTravel(rootNode.rChild, treeMap, hd + 1);
    }

//    public void verticalTreeTravel(Node rootNode) {
//        if (rootNode == null) return;
//        int hd = 0;
//        Queue queue = new LinkedList();
//        Map map = new Hashtable();
//
//        queue.add(rootNode);
//        map.put(hd, rootNode.data);
//
//        while (!queue.isEmpty()) {
//            Node current = (Node) queue.remove();
//            if (current.lChild != null) {
//                queue.add(current.lChild);
//                hd = hd - 1;
//                map.put(hd, current.lChild.data);
//            }
//            if (current.rChild != null) {
//                queue.add(current.rChild);
//                hd = hd + 1;
//                map.put(hd, current.rChild.data);
//            }
//        }
//        System.out.println("testing" + map.toString());
//    }
}
