package datastructure.tree;

import java.util.ArrayList;

public class BinaryTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
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
       if (!flag.isEmpty()){
           if (flag.equals("left"))
               root.left = node;
           else
               root.right = node;
       }

    }
}
