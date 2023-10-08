package datastructure.tree;

import java.util.*;

public class Tree {

    Node rootNode;
    List<Integer> listOfData = new ArrayList<>();

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
                p.left = t;
                queue.add(t);
            }
            System.out.println("Enter Right child of " + p.data);
            int right = scanner.nextInt();

            if (right != -1) {
                t = new Node(right);
                p.right = t;
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
        preOrder(rootNode.left);
        preOrder(rootNode.right);
    }

    public void postOrder(Node rootNode) {
        if (rootNode == null) return;
        preOrder(rootNode.left);
        preOrder(rootNode.right);
        System.out.println("" + rootNode.data);

    }

    public void inOrder(Node rootNode) {
        if (rootNode == null) return;
        preOrder(rootNode.left);
        System.out.println("" + rootNode.data);
        preOrder(rootNode.right);

    }

    public void preOrderI(Node rootNode) {
        Stack<Node> stack = new Stack();
        while (rootNode != null || !stack.isEmpty()) {
            if (rootNode != null) {
                System.out.println("" + rootNode.data);
                stack.push(rootNode);
                rootNode = rootNode.left;
            } else {
                rootNode = stack.pop();
                rootNode = rootNode.right;
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
            if (p.left != null) {
                subList.add(p.left.data);
                queue.add(p.left);
            }
            if (p.right != null) {
                subList.add(p.right.data);
                queue.add(p.right);
            }
        }

        return list;
    }

    public int count(Node rootNode) {
        int x, y;
        if (rootNode != null) {
            x = count(rootNode.left);
            y = count(rootNode.right);
            if (rootNode.right != null && rootNode.left != null)
                return x + y + 1;
        }
        return 0;
    }

    public List<Integer> preorderTravelList(Node rootNode) {
        if (rootNode != null) {
            listOfData.add(rootNode.data);
            preorderTravelList(rootNode.left);
            preorderTravelList(rootNode.right);
        }
        return listOfData;
    }

    public List<Integer> preorderTravelListI(Node rootNode) {
        Stack<Node> stack = new Stack<>();
        while (rootNode != null || !stack.isEmpty()) {
            if (rootNode != null) {
                listOfData.add(rootNode.data);
                stack.push(rootNode);
                rootNode = rootNode.left;
            } else {
                rootNode = stack.pop();
                rootNode = rootNode.right;
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
                current = current.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.data + " ");
                    listOfData.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
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
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isSys(root.left, root.right);
    }

    public boolean isSys(Node left, Node right) {
        if (left == null || right == null)
            return left == right;
        if (left.data != right.data)
            return false;

        return isSys(left.left, right.right) && isSys(left.right, right.left);
    }

    public Boolean isBst(Node rootNode) {
        if (rootNode == null) return true;

        int lmax = maxOfLeftSide(rootNode.left);
        System.out.println("left data" + lmax);
        int rMin = minOfRightSide(rootNode.right);
        System.out.println("right data" + rMin);

        return rootNode.data > lmax && rootNode.data < rMin;


    }

    public int maxOfLeftSide(Node rootNode) {
        int res = Integer.MIN_VALUE;
        if (rootNode == null)
            return res;

        if (rootNode.left != null)
            res = rootNode.left.data;

        int maxSub = Math.max(maxOfLeftSide(rootNode.left), maxOfLeftSide(rootNode.right));
        return Math.max(maxSub, res);
    }

    public int minOfRightSide(Node root) {
        int res = Integer.MAX_VALUE;
        if (root == null) return res;

        if (root.right != null)
            res = root.right.data;

        int maxSub = Math.min(minOfRightSide(root.left), minOfRightSide(root.right));

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
//        getVerticalOrder(root.left, hd - 1, m);
//
//        // Store nodes in right subtree
//        getVerticalOrder(root.right, hd + 1, m);
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

        verticalTreeTravel(rootNode.left, treeMap, hd - 1);
        verticalTreeTravel(rootNode.right, treeMap, hd + 1);
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
//            if (current.left != null) {
//                queue.add(current.left);
//                hd = hd - 1;
//                map.put(hd, current.left.data);
//            }
//            if (current.right != null) {
//                queue.add(current.right);
//                hd = hd + 1;
//                map.put(hd, current.right.data);
//            }
//        }
//        System.out.println("testing" + map.toString());
//    }
}
