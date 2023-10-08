package datastructure.java8.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

    List<String> words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
    Stream<String> stream = words.stream();

    Stream<String> stringStream = Stream.of("hello", "hola", "hallo", "ciao");


}
