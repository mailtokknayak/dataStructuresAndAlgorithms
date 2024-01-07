package datastructure.stack;

import java.util.Arrays;

public class StackMain {

    public static void stackMain() {
        System.out.println("Inside StackMain");


//        Stack stack = new Stack(10);
//        stack.push(1);
//        stack.push(15);
//        stack.push(8);
//        stack.push(5);
//        System.out.println(stack.min() + " min data");

        StackAVProblems stackAVProblems = new StackAVProblems();
        int[] arr = {1, 3, 0, 0, 1, 2, 4};
//        System.out.println(Arrays.toString(stackAVProblems.nearestGreaterToRight(arr)));
//        System.out.println(Arrays.toString(stackAVProblems.nearestGreaterToLeft(arr)));
//        System.out.println(Arrays.toString(stackAVProblems.nearestLowerToRight(arr)));
//        System.out.println(Arrays.toString(stackAVProblems.nearestLowerToLeft(arr)));
//        System.out.println(Arrays.toString(stackAVProblems.stockSpanProblem(arr)));
//        long[] arr1 = {7 ,8 ,1 ,4};
//        System.out.println(Arrays.toString(stackAVProblems.nextLargerElement(arr1, 4)));
        System.out.println(stackAVProblems.isBalanced("{[()]}"));
    }

}
