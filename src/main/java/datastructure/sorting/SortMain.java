package datastructure.sorting;

public class SortMain {

    public static void sortMain(){

        System.out.println("Inside SortMain");

        int[] nums = {18, 10, 2, 15, 25, 6};
        int[] nums1 = {1, 2, 3, 4, 5};
        Sort sort = new Sort();
        nums = sort.quickSort(nums, 0, nums.length - 1);
        nums = sort.selectionSort(nums);
        sort.show(nums);
    }
}
