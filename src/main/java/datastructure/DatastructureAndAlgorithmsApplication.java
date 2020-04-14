package datastructure;

import datastructure.arrays.Array;
import datastructure.linkedlist.LinkedList;
import datastructure.sorting.Sort;
import datastructure.tree.Tree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatastructureAndAlgorithmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatastructureAndAlgorithmsApplication.class, args);

        System.out.println("In main Application!!");
//        int[] nums = {1, 2, 3, 4, 6, 7, 9, 8, 10};
//        Array array = new Array();
//		array.findMissingNumber1toN(10, nums);
//        int[] nums1 = {1, 2, 2, 4, 50, 66, 90, 180, 1000};
//		array.findDuplicateNumS(nums1);
//        int[] nums2 = {1, 50, 66, 90, 4, 2, 4, 180, 1000};
//		array.findDuplicateNumUS(nums2);
//        int[] nums3 = {1, 50, 66, 90, 4, 2, 4, 180, 1000};
//		array.checkNumber1(nums3, 180);
//        int[] nums4 = {1, 50, 66, 90, 4, 2, 4, 180, 1000};
//		array.binarySearch(nums4, 180);

//
//["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//[[],[1],[3],[1,2],[1],[0],[0]]




//		LinkedList ls = new LinkedList();
//		ls.insertAtHead(1);
//		ls.insertAtTail(2);
//		ls.insertAtTail(3);
//		ls.insertAtTail(4);
//		ls.insertAtTail(5);
//		ls.deleteNthNodeFromEnd(1);

//[3,2,0,-4]

//		ls.insertAtHead(4);
//		ls.insertAtIndex(5, 0);
//		ls.insertAtHead(6);


//		ls.display();


//        Tree tree = new Tree();
//
//        tree.create();

        int[] nums = {18,10,2,15,25,6};
//        int[] nums = {1,2,3,4,5};
        Sort sort = new Sort();
          nums = sort.quickSort(nums, 0, nums.length-1);
         sort.show(nums);

    }

}
