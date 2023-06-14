package datastructure.recursion;


import java.util.ArrayList;

public class RecursionProblems {

    public RecursionProblems() {
    }


    public void printNumber(int n) {
        if (n > 0) {
            printNumber(n - 1);
            System.out.println(n);
        }
    }

    public ArrayList sort(ArrayList arr) {
        if (arr.size() == 1)
            return arr;

        int temp = (int) arr.remove(arr.size() - 1);
        sort(arr);
        return insert(arr, temp);
    }

    private ArrayList insert(ArrayList arr, int temp) {
        if (arr.size() == 0 || (int) arr.get(arr.size() - 1) < temp)
            return arr;

        return arr;

    }

}



