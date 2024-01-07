package datastructure.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.peek();
    }

    public int findKthSmallest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a-b);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k)
                priorityQueue.remove();
        }
        return priorityQueue.peek();
    }

    public ArrayList<Integer> findKthLargestElements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k)
                queue.remove();
        }
        while (!queue.isEmpty())
            list.add(queue.remove());
        return list;
    }

    public ArrayList<Integer> sortKSortedArray(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ArrayList<Integer> out = new ArrayList<>();
        int i = 0;
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                out.add(priorityQueue.remove());
            }
        }
        while (!priorityQueue.isEmpty())
            out.add(priorityQueue.remove());
        return out;
    }
}
