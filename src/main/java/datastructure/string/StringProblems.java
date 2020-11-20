package datastructure.string;

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

    public String reverseStringWithBuilder(String str){
        StringBuilder stringBuilder= new StringBuilder();
       return stringBuilder.append(str).reverse().toString();
    }

    public void printDuplicate(String str){
        if (str.isEmpty())
            return;

        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++){
            for (int j=i+1;j<chars.length;j++){
                if (chars[i] == chars[j])
                    System.out.println(chars[i]);
            }
        }
    }
}
