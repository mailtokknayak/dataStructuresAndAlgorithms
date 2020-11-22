package datastructure.mustDoGFG;

public class GFGMain {
    public static void gfgMain(){

        System.out.println("Inside GFGMain");


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 11;
        TreeProblems treeProblems = new TreeProblems();
        ArrayProblems arrayProblems = new ArrayProblems();
        arrayProblems.subArrayWithGivenSumM1(arr,sum, 10);
        arrayProblems.findMissingNumber();
    }
}
