package datastructure.tree;

import datastructure.tree.freeKaTree.TreeQuestions;

public class TreeMain {

    public static void treeMain() {
        System.out.println("Inside TreeMain");

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Tree tree = new Tree();
        TreeQuestions tree = new TreeQuestions();
        System.out.print("preR -> ");
        tree.preOrderR(tree.create(array, 0));
        System.out.println("");
        System.out.print("postR -> ");
        tree.postOrderR(tree.create(array, 0));
        System.out.println("");
        System.out.print("inR -> ");
        tree.inOrderR(tree.create(array, 0));
        System.out.println("");
        System.out.print("levelR -> ");
        tree.levelOrderR(tree.create(array, 0));
        System.out.println("");
        System.out.print("preI -> ");
        tree.preOrderI(tree.create(array, 0));
        System.out.println("");
        System.out.print("inI -> ");
        tree.inOrderI(tree.create(array, 0));
        System.out.println("");
        System.out.print("postI -> ");
        tree.postOrderI(tree.create(array, 0));
        System.out.println("");
        System.out.print("tree from pre and in -> ");
        tree.postOrderI(tree.buildTreeFromPreIn());
        System.out.println("");
        System.out.print("tree height -> "+ tree.maxHeightBst(tree.buildTreeFromPreIn()));
//        tree.maxHeightBst(tree.buildTreeFromPreIn());
        System.out.println("");
        System.out.print("tree is balance  -> "+ tree.isTreeIsBalance(tree.buildTreeFromPreIn()));

    }

}
