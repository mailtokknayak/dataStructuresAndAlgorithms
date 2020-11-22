package datastructure;

import datastructure.arrays.ArrayMain;
import datastructure.binarySearch.BinarySearchMain;
import datastructure.knapsack.KnapsackMain;
import datastructure.linkedlist.LinkedListMain;
import datastructure.mustDoGFG.GFGMain;
import datastructure.sorting.SortMain;
import datastructure.stack.StackMain;
import datastructure.string.StringMain;
import datastructure.tree.TreeMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataStructureAndAlgorithmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStructureAndAlgorithmsApplication.class, args);

        System.out.println("In main Application!!");

        ArrayMain.arrayMain();
        LinkedListMain.linkedListMain();
        TreeMain.treeMain();
        KnapsackMain.knapsackMain();
        StringMain.stringMain();
        SortMain.sortMain();
        BinarySearchMain.binarySearchMain();
        StackMain.stackMain();
        GFGMain.gfgMain();
        StackMain.stackMain();

    }

}
