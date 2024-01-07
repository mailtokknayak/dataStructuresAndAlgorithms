package datastructure.string;


import java.util.Stack;

public class StringProblems {

    //todo reference -> https://medium.com/javarevisited/top-21-string-programming-interview-questions-for-beginners-and-experienced-developers-56037048de45

    public String reverseString(String str) {

        if (str.isEmpty() || str == null)
            return str;

        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public String reverseStringWithBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(str).reverse().toString();
    }

    public void printDuplicate(String str) {
        if (str.isEmpty())
            return;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j])
                    System.out.println(chars[i]);
            }
        }
    }

    public static String superReducedString(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        if (s.length() == 0)
            return stringBuffer.toString();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty())
            stringBuffer.append(stack.pop());

        return stringBuffer.reverse().toString();
    }

    public int patternMatch(String str, String pattern) {
//       int i1 =  str.indexOf(pattern);
        int n = str.length();
        int m = pattern.length();
        int i = 0;
        int j = m - 1;
        for (i = 0, j = m - 1; j < n; ) {
            if (pattern.equals(str.substring(i, j + 1))) {
                return i;
            } else {
                i++;
                j++;
            }
        }
        return -1;
    }
}
