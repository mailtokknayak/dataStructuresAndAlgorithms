package datastructure.knapsack;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Knapsack {
    static int[][] dp;
    static boolean[][] dp1;
    static int[] out;

    public static void test() {
//        Scanner sc  = new Scanner(System.in);
//        int t = sc.nextInt();
//        for(int i=0;i<t;i++){
//            int size = sc.nextInt();
//            int capacity = sc.nextInt();
//            int[] weights = new int[size];
//            int[] values = new int[size];
//
//            for(int j=0;j<size;j++){
//                values[j] = sc.nextInt();
//            }
//
//            for(int j=0;j<size;j++){
//                weights[j] = sc.nextInt();
//            }
//
        int size = 7;
        int capacity = 5;
//        int[] weights = {1, 3, 4, 5};
        int[] weights = {4, 3, 2, 3, 5, 2, 1};
        int[] values = {1, 4, 5, 7};
//        dp1 = new boolean[size + 1][capacity + 1];
//        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
//        int out = knapsackTopDown1(weights, values, capacity, size);

//        boolean out = isSubSetTD(weights, capacity, size);
        int out = countOfSubset(weights, capacity, size);
        System.out.println(">>>>>>>>>" + out);
    }


    public static int knapsackMemoized(int[] weights, int[] values, int capacity, int size) {

        if (capacity == 0 || size == 0)
            return 0;

        if (dp[size][capacity] != -1)
            return dp[size][capacity];

        if (weights[size - 1] <= capacity) {
            return dp[size][capacity] = Math.max(values[size - 1] + knapsackMemoized(weights, values, capacity - weights[size - 1], size - 1),
                    knapsackMemoized(weights, values, capacity, size - 1));
        } else {
            return dp[size][capacity] = knapsackMemoized(weights, values, capacity, size - 1);
        }
    }

    public static int knapsackTopDown(int[] wt, int[] vals, int w, int n) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i] <= j) {
                    dp[i][j] = Math.max(vals[i] + dp[i - 1][j - wt[i]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }

    public static int knapsackTopDown1(int[] wt, int[] val, int w, int n) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }


    public static int isSubSet(int[] arr, int s, int n) {
        if (s == 0) {
            dp[n][s] = 1;
            return dp[n][s];
        }
        if (n == 0) {
            dp[n][s] = 0;
            return dp[n][s];
        }
        if (dp[n][s] != -1) {
            return dp[n][s];
        }
        if (arr[n - 1] > s) {
            dp[n][s] = isSubSet(arr, n - 1, s);
            return dp[n][s];
        } else {
            if ((isSubSet(arr, n - 1, s) == 1) || (isSubSet(arr, n - 1, s - arr[n - 1]) == 1))
                dp[n][s] = 1;
            else
                dp[n][s] = 0;
            return dp[n][s];
        }
    }

    public static boolean isSubSetTD(int[] arr, int sum, int n) {
        dp1 = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) dp1[i][j] = false;
                if (j == 0) dp1[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    dp1[i][j] = dp1[i - 1][j - arr[i - 1]] || dp1[i - 1][j];
                else
                    dp1[i][j] = dp1[i - 1][j];
            }
        }
        return dp1[n][sum];
    }

    public static boolean isEqualSum(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + arr[i];

        if (sum % 2 != 0 || n == 0)
            return false;

        return isSubSetTD(arr, sum / 2, n);
    }

    public  static int countOfSubset(int[] arr, int sum, int n){
        dp = new int[n + 1][sum + 1];

        int sum1 = 0;
        for (int i = 0; i < n; i++)
            sum1 = sum1 + arr[i];

        if (sum1 % 2 != 0 || n == 0)
            return 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] +  dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

}
