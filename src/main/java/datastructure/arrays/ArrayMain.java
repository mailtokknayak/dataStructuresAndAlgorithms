package datastructure.arrays;


public class ArrayMain {

    public static void arrayMain() {

        System.out.println("Inside ArrayMain");

        int[] nums = {1, 2, 3, 4, 6, 7, 9, 8, 10};
        Array array = new Array();

//        array.findMissingNumber1toN(10, nums);
//        int[] nums1 = {1, 2, 2, 4, 50, 66, 90, 180, 1000};
//        array.findDuplicateNumS(nums1);
//        int[] nums2 = {1, 50, 66, 90, 4, 2, 4, 180, 1000};
//        array.findDuplicateNumUS(nums2);
//        int[] nums3 = {1, 50, 66, 90, 4, 2, 4, 180, 1000};
//        array.checkNumber1(nums3, 180);
//        int[] nums4 = {1, 50, 66, 90, 4, 2, 4, 180, 1000};
//        array.binarySearch(nums4, 180);
        int[][] nums5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        array.findDiagonalOrder(nums5);
    }
}
