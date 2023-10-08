package datastructure.stream;

import java.util.Arrays;
import java.util.List;

public class StreamAPI {

    List<String> list = Arrays.asList("aaa", "abc", "abcd");

    public void find() {
        list.stream().filter(str -> str.startsWith("a"));
    }

}
