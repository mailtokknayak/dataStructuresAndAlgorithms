package datastructure.stack;

public class StackMain {

    public static void stackMain(){
        System.out.println("Inside StackMain");


        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(15);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.min() + " min data");
    }

}
