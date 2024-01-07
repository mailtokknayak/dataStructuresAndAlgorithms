package mustDoGFG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

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

    public List<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (currSum - s == 0) {
                list.add(0);
                list.add(i);
                return list;
            }
            if (map.containsKey(currSum - s)) {
                list.add(map.get(currSum - s) + 1);
                list.add(i);
                return list;
            }

            map.put(currSum, i);
        }
        return list;
    }

    int countTriplet(int arr[], int n) {
        // code here
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(arr[i] + arr[j])) {
                    count++;
                }
            }
        }
        return count;
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

    public void mergeSortedArraysM1(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];
        int k = 0;
        int left = 0;
        int right = 0;
        for (left = 0, right = 0; left < n && right < m; ) {
            if (a[left] < b[right]) {
                result[k++] = a[left++];
            } else {
                result[k++] = b[right++];
            }
        }
        while (left < n) {
            result[k++] = a[left++];
        }
        while (right < m) {
            result[k++] = b[right++];
        }
    }

    public void mergeSortedArraysM2(int[] a, int[] b){
        int n = a.length;
        int m = b.length;

        int left = n-1;
        int right = 0;

        while (left >= 0 && right < m){
            if (a[left] > b[right]){
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
