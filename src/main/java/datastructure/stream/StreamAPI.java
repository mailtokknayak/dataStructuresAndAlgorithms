package datastructure.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    List<String> list = Arrays.asList("aaa", "abc", "abcd");

    public void find() {
        list.stream().filter(str -> str.startsWith("a"));
    }

}
