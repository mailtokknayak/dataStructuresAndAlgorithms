package datastructure.arrays;


import java.util.HashSet;
import java.util.Set;

public class Array {

    public Array() {
    }

    public void findMissingNumber1toN(int n, int[] nums) {
        int size = nums.length;
        int actualSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + nums[i];
        }
        System.out.println("Missing Number is " + (actualSum - sum));
    }

    public void findDuplicateNumS(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                System.out.println("Duplicate Number is " + nums[i]);

        }
    }

    public void findDuplicateNumUS(int[] nums) {
        //Todo we can use sort and previous function
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (!set.add(nums[i]))
                System.out.println("Duplicate Number is " + nums[i]);
        }
    }

    public void checkNumber1(int[] nums, int key) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key)
                System.out.println("Found - " + key);
        }
    }

    public void binarySearch(int[] nums, int key) {
        int low = 0, high = nums.length;
        int pivot = low + high / 2;

        while (low < high) {
            if (key < nums[pivot])
                high = pivot - 1;
            else if (key > nums[pivot])
                low = pivot + 1;
            else
                System.out.println("Found - " + nums[pivot]);
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {

        if (mat.length == 0 || mat[0].length == 0)
            return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int[] output = new int[m * n];

        int row = 0, col = 0;
        boolean up = true;

        while (row < m && col < n) {

            if (up) {
                while (row > 0 && col < n - 1) {
                    output[i++] = mat[row][col];
                    row--;
                    col++;
                }
                output[i++] = mat[row][col];
                if (col == n - 1)
                    row++;
                else
                    col++;
            } else {
                while (row < m - 1 && col > 0) {
                    output[i++] = mat[row][col];
                    row++;
                    col--;
                }
                output[i++] = mat[row][col];

                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }
        return output;
    }
}
