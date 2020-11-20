package datastructure.mustDoGFG.arrays;

import java.util.Scanner;

public class ArrayProblems {


    public void subArrayWithGivenSumM1(int[] arr, int sum, int n) {

        int current_sum, i, j;

        for (i = 0; i < n - 1; i++) {
            current_sum = arr[i];

            for (j = i + 1; j < n - 1; j++) {

                if (current_sum == sum) {
                    int k = j - 1;
                    int h = i + 1;
                    System.out.println("found pair" + h + "to" + k);
                    return;
                }
                if (current_sum > sum)
                    break;
                current_sum = current_sum + arr[j];
            }
        }
    }

    public void findMissingNumber() {
        Scanner sc = new Scanner(System.in);
        int noOfTest = sc.nextInt();

        for (int i = 0; i < noOfTest - 1; i++) {
            int size = sc.nextInt();
            int[] arr = new int[size];

            for (int j = 0; j < size - 1; j++) {
                arr[j] = sc.nextInt();
            }
            int sum = 0;

            for (int k = 0; k < size - 1; k++) {
                sum = sum + arr[k];
            }

            int actualSum = (size * (size + 1)) / 2;


            System.out.println("" + (actualSum - sum));
        }

    }
}
