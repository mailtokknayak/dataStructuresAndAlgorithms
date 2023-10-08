package datastructure.mustDoGFG;

public class GFGMain {
    public static void main() {

        System.out.println("Inside GFGMain");


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 11;

//        ArrayProblems arrayProblems = new ArrayProblems();
//        arrayProblems.subArrayWithGivenSumM1(arr,sum, 10);
//        arrayProblems.findMissingNumber();
        TreeProblems treeProblems = new TreeProblems();
        String input = "849 96 71 688 915 325 327 885 20 N N 11 54 304 584 672 270 N N N N N N 899 602 N N N N N N 244 856 61 N N N N N N N";
        TreeProblems.Node root = TreeProblems.buildTree(input);
//        System.out.println("left view" + treeProblems.leftView(root));
//        System.out.println("bottom view" + treeProblems.bottomView(root));
//        System.out.println("top view" + treeProblems.topView(root));
//        System.out.println("vertical order" + treeProblems.bottomView(root));
//        System.out.println("leaf node " + treeProblems.countLeaves(root));
        System.out.println("isBalanced " + treeProblems.isBalanced(root));
    }
}
