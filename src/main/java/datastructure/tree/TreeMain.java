package datastructure.tree;

public class TreeMain {

    public static void treeMain() {
        System.out.println("Inside TreeMain");

//        int[] array = {3,1,2};
////        Tree tree = new Tree();
//        TreeQuestions tree = new TreeQuestions();
//        System.out.print("preR -> ");
//        tree.preOrderR(tree.create(array, 0));
//        System.out.println("");
//        System.out.print("postR -> ");
//        tree.postOrderR(tree.create(array, 0));
//        System.out.println("");
//        System.out.print("inR -> ");
//        tree.inOrderR(tree.create(array, 0));
//        System.out.println("");
//        System.out.print("levelR -> ");
//        tree.levelOrderR(tree.create(array, 0));
//        System.out.println("");
//        System.out.print("preI -> ");
//        tree.preOrderI(tree.create(array, 0));
//        System.out.println("");
//        System.out.print("inI -> ");
//        tree.inOrderI(tree.create(array, 0));
//        System.out.println("");
//        System.out.print("postI -> ");
//        tree.postOrderI(tree.create(array, 0));
//        System.out.println("");
//        System.out.print("tree from pre and in -> ");
//        tree.postOrderI(tree.buildTreeFromPreIn());
//        System.out.println("");
//        System.out.print("tree height -> "+ tree.maxHeightBst(tree.buildTreeFromPreIn()));
////        tree.maxHeightBst(tree.buildTreeFromPreIn());
//        System.out.println("");
//        System.out.print("tree is balance  -> "+ tree.isTreeIsBalance(tree.buildTreeFromPreIn()));


        BinaryTree binaryTree = new BinaryTree();
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {-2147483648, -2147483648};
        int[] nums = {2, 1, 3};

        binaryTree.root = binaryTree.createBinaryTree(nums);
//        binaryTree.root = binaryTree.createBinaryTreeR(nums, 0);
//        List<Integer> list = new ArrayList<>();
//        List<Integer> out = binaryTree.inorderTraversal(binaryTree.root);
//        List<List<Integer>> out1 = binaryTree.levelOrderTraversal(binaryTree.root);
//        boolean isPathSum = binaryTree.pathSum(binaryTree.root, 55);
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
//        binaryTree.buildTree(preorder, inorder);
//        binaryTree.isBst(binaryTree.root);
//        binaryTree.isBstM2(binaryTree.root);
//        binaryTree.inOrder(binaryTree.root);
//        binaryTree.postOrder(binaryTree.root);

//        BinaryTree.printTree(binaryTree.root);

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println("is BST -> " + binarySearchTree.isBstM1(binaryTree.root));
        System.out.println("is BST -> " + binarySearchTree.isBstM1(binaryTree.root));
    }

}
