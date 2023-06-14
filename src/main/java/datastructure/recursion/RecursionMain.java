package datastructure.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionMain {

    public static void recursionMain() {
        RecursionProblems recursionProblems = new RecursionProblems();
//        recursionProblems.printNumber(5);
        ArrayList arr = new ArrayList(
                Arrays.asList(3, 2, 1, 4, 5, 6, 7)
        );
        recursionProblems.sort(arr);
        System.out.println(arr);
    }
}
