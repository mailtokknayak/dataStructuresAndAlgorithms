package datastructure.tree;

import java.util.*;

public class Tree {

    Node rootNode;
    List<Integer> listOfData = new ArrayList<>();

    class Node {
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
        System.out.println("Pre order");
        preOrderI(rootNode);
        System.out.println("post order");
        postOrder(rootNode);
        System.out.println("in order");
        inOrder(rootNode);

        System.out.println("Level Traversal");
        levelTraversal();

        System.out.println("count" + count(rootNode));

//        System.out.println("preorderTravelList" + preorderTravelListI(rootNode));
        System.out.println("postorderTravelListI" + postorderTravelListI(rootNode));
        System.out.println("maxDepth" + maxDepth(rootNode));
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

    public List<Integer> postorderTravelListI(Node root) {
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
        boolean right= isSymmetric(root.rChild);
        return left&& right;
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
}
