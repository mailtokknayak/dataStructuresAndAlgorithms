package datastructure.sorting;

public class Sort {
    public Sort() {
    }


    public int[] bubbleSort(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums = swap(j, j + 1, nums);
                    flag = 1;
                }
            }
            if (flag == 0) break;
        }
        return nums;
    }

    public int[] insertionSort(int[] nums) {
        int j, x;
        for (int i = 1; i < nums.length; i++) {
            j = i - 1;
            x = nums[i];

            while (nums[j] > x) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = x;
        }

        return nums;
    }

    public int[] selectionSort(int[] nums) {
        int j, k;
        for (int i = 0; i < nums.length - 1; i++) {
            for (j = k = i; j < nums.length; j++) {
                if (nums[j] < nums[k])
                    k = j;
            }
            nums = swap(i, k, nums);
        }
        return nums;
    }

    public int[] quickSort(int[] nums, int low, int high) {
        int pivot = partition1(nums, low, high);
        if (low < high) {
            nums = quickSort(nums, low, pivot);
            nums = quickSort(nums, pivot + 1, high);
        }
        return nums;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low, j = high;
        do {
            do {
                i++;
            } while (nums[i] < pivot);
            do {
                j--;
            } while (nums[j] > pivot);
            if (i < j)
                nums = swap(i, j, nums);
        } while (i < j);

        nums = swap(low, j, nums);
        return j;
    }

    public void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("" + nums[i]);
        }
    }

    private int[] swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    private int partition1(int[] nums, int l, int h) {
        int pivot = nums[l];
        int i = l;
        int j = h;

        while (i < j) {
            while (nums[i] <= pivot && i < h) i++;
            while (nums[j] > pivot && j > l) j--;
            if (i < j)
                swap(i, j, nums);
        }
        if (j != l)
            swap(j, l, nums);
        return j;
    }

}
