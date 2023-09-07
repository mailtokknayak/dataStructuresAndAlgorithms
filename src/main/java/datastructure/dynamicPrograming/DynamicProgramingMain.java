package datastructure.dynamicPrograming;

import java.util.Arrays;

public class DynamicProgramingMain {

    public static void mainFun() {
        KnapsackProblems KnapsackProblems = new KnapsackProblems();

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int w = 50;
        int n = 3;

        int[][] dp = new int[n + 1][w + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println("knapsack " + KnapsackProblems.knapsack(wt, val, w, n));
        System.out.println("knapsackMemoization " + KnapsackProblems.knapsackMemoization(wt, val, w, n, dp));
        System.out.println("knapsackTopDown " + KnapsackProblems.knapsackTopDown(wt, val, w, n));

        wt = new int[]{2, 3, 7, 8, 10};
        w = 130;
        n = 5;

        System.out.println("isSubSetSum " + KnapsackProblems.subSetSum(wt, w, n));
    }


}
