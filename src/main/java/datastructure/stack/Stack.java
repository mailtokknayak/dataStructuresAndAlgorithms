package datastructure.stack;

public class Stack {

    int[] intStack;
    int top = 0;

    public Stack(int size) {
        intStack = new int[size];
    }

    public Stack() {
    }


    public void push(int data) {
        intStack[top] = data;
        top++;
    }

    public int pop() {
        top--;
        int data = intStack[top];
        intStack[top] = 0;
        return data;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int peek() {
        if (!isEmpty()) return intStack[top - 1];
        return -1;
    }

    public int min() {
        Stack minStack = new Stack(10);
        while (!isEmpty()) {
            int data = pop();
            if (minStack.isEmpty())
                minStack.push(data);
            else {
                if (minStack.peek() < data)
                    minStack.push(data);
            }
        }
        return minStack.pop();
    }


}
