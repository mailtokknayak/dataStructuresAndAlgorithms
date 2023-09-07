package datastructure.dynamicPrograming;

public class KnapsackProblems {


    public int knapsack(int[] wt, int[] val, int w, int n) {

        if (w == 0 || n == 0)
            return 0;

        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
        } else {
            return knapsack(wt, val, w, n - 1);
        }
    }

    public int knapsackMemoization(int[] wt, int[] val, int w, int n, int[][] dp) {

        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max(val[n - 1] + knapsackMemoization(wt, val, w - wt[n - 1], n - 1, dp), knapsackMemoization(wt, val, w, n - 1, dp));
        } else {
            return dp[n][w] = knapsackMemoization(wt, val, w, n - 1, dp);
        }
    }

    public int knapsackTopDown(int[] wt, int[] val, int w, int n) {

        if (w == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    public boolean subSetSum(int[] arr, int w, int n) {

        if (w == 0 || n == 0) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

}
