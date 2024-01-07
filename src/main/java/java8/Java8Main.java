package java8;


import java.util.Arrays;
import java.util.List;

public class Java8Main {

    public static void mainFun() {
        System.out.println("In Side Java8Main Class");
        Java8Problems java8Problems = new Java8Problems();
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        java8Problems.findEvenNumber(list);
    }
}
