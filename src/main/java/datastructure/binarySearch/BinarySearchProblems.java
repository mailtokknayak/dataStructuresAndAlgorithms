package datastructure.binarySearch;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class BinarySearchProblems {

    public int binarySearchForOccurrence(int[] arr, int key, String occurrence) {
        if (arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;
        int out = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                out = mid;
                switch (occurrence) {
                    case "first":
                        high = mid - 1;
                        break;
                    case "last":
                        low = mid + 1;
                        break;

                }

            } else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return out;
    }

    public void findAndLastOccurrence(int[] arr, int key) {

        int first = binarySearchForOccurrence(arr, key, "first");
        int last = binarySearchForOccurrence(arr, key, "last");
        System.out.println("first " + first + " last " + last);
    }

    public void countOfElement(int[] arr, int key) {

        int first = binarySearchForOccurrence(arr, key, "first");
        int last = binarySearchForOccurrence(arr, key, "last");
        System.out.println("countOfElement " + (last - first + 1));
    }


    public int numberOfTimeRotation(int[] arr) {  //todo also can be implemented for minimum element
        //index of shorted element
        int start = 0;
        int end = arr.length - 1;
        int next = 0;
        int prev = 0;
        int n = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            next = (mid + 1) % n;
            prev = (mid - 1 + n) % n;

            if (arr[prev] >= arr[mid] && arr[mid] <= arr[next]) {
                return mid;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int findElementInSorted(int[] arr, int key) {
        int result = -1;
        int minIndex = numberOfTimeRotation(arr);
        if (arr[minIndex - 1] <= key) {
            int[] subArrays = Arrays.copyOfRange(arr, 0, minIndex - 1);
            result = binarySearch(subArrays, key);
        } else {
            int[] subArrays = Arrays.copyOfRange(arr, minIndex + 1, arr.length - 1);
            result = binarySearch(subArrays, key) + minIndex;
        }
        return result;
    }

    public int findElementInNearByArray(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid])
                return mid;
            else if (mid - 1 > low && key == arr[mid - 1])
                return mid - 1;
            else if (mid + 1 < high && key == arr[mid + 1])
                return mid + 1;

            if (arr[mid] > key) {
                high = mid - 2;
            } else
                low = mid + 2;
        }
        return -1;
    }

    public int findFloorOfElement(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                result = mid;
                return result;
            } else if (arr[mid] < key) {
                low = mid + 1;
                result = mid;
            } else if (arr[mid] > key)
                high = mid-1;

        }
        return result;
    }
}
