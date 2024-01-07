package datastructure.heap;

import java.util.Arrays;

public class HeapMain {

    public static void main() {
        System.out.println("Inside HeapMain!");
        Heap heap = new Heap();
        int[] nums = {2, 4, 5, 7, 90, 12, 34, 56};
        int k = 3;
        System.out.println(heap.findKthLargest(nums, k));
        System.out.println(heap.findKthSmallest(nums, k));
        System.out.println(heap.findKthLargestElements(nums, k));
        System.out.println(heap.sortKSortedArray(nums, k));
    }
}
