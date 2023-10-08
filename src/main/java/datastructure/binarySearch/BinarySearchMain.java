package datastructure.binarySearch;

public class BinarySearchMain {

    public static void binarySearchMain() {
        System.out.println("Inside BinarySearchMain");


        BinarySearchProblems binarySearchProblems = new BinarySearchProblems();
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 12, 29};
//        System.out.println("index is " + binarySearchProblems.binarySearch(arr, 12));
        binarySearchProblems.findAndLastOccurrence(arr, 10);
        binarySearchProblems.countOfElement(arr, 10);

        System.out.println("index is " + binarySearchProblems.numberOfTimeRotation(arr));
        System.out.println("element  is " + binarySearchProblems.findElementInSorted(arr, 1));
        System.out.println("element  is " + binarySearchProblems.findElementInNearByArray(arr, 40));
//
    }
}
