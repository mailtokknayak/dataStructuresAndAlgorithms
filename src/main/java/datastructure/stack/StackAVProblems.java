package datastructure.stack;

import java.util.Stack;

public class StackAVProblems {

    public int[] nearestGreaterToRight(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack();
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                output[i] = -1;
                stack.push(arr[i]);
            } else {
                if (stack.peek() > arr[i]) {
                    output[i] = stack.peek();
                    stack.push(arr[i]);
                } else {
                    while (stack.isEmpty() || stack.peek() <= arr[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        output[i] = -1;
                    } else {
                        output[i] = stack.peek();
                        stack.push(arr[i]);
                    }
                }
            }
        }
        return output;
    }

    public int[] nearestGreaterToLeft(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack();
        int[] output = new int[n];

        for (int i = 0; i <= n - 1; i++) {
            if (stack.isEmpty()) {
                output[i] = -1;
                stack.push(arr[i]);
            } else {
                if (stack.peek() > arr[i]) {
                    output[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && stack.peek() < arr[i]) {
                        stack.pop();
                    }

                    if (stack.isEmpty())
                        output[i] = -1;
                    else {
                        output[i] = stack.peek();
                        stack.push(arr[i]);
                    }
                }
            }
        }

        return output;
    }

    public int[] nearestLowerToRight(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                output[i] = -1;
                stack.push(arr[i]);
            } else {
                if (stack.peek() < arr[i]) {
                    output[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                        stack.pop();
                    }

                    if (stack.isEmpty()) {
                        output[i] = -1;
                        stack.push(arr[i]);
                    }
                    if (stack.peek() < arr[i]) {
                        output[i] = stack.peek();
                    }

                }
            }
        }
        return output;
    }

    public int[] nearestLowerToLeft(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n - 1; i++) {
            if (stack.isEmpty()) {
                output[i] = -1;
                stack.push(arr[i]);
            } else {
                if (stack.peek() < arr[i]) {
                    output[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        output[i] = -1;
                        stack.push(arr[i]);
                    }
                    if (stack.peek() < arr[i]) {
                        output[i] = stack.peek();
                    }
                }
            }
        }
        return output;
    }

    public int[] stockSpanProblem(int[] arr) {
        arr = new int[]{10, 4, 5, 90, 120, 80};
        int n = arr.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                output[i] = i + 1;
                stack.push(i);
            } else {
                if (arr[stack.peek()] > arr[i]) {
                    output[i] = i - stack.peek();
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        output[i] = i + 1;
                        stack.push(i);
                    }
                    if (arr[stack.peek()] > arr[i]) {
                        output[i] = i - stack.peek();
                        stack.push(i);
                    }
                }
            }
        }
        return output;

    }
}
