package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Problems {
    public void findEvenNumber(List<Integer> list) {
//        list.stream().filter(l -> l % 2 == 0).forEach(System.out::println);
//
//
//        Map<String, String> map = new HashMap<>();
//        map.put("1","krishn");
//        map.put("2","kant");
//        map.put("3","nayak");
//        Set<Map.Entry<String, String>> set = map.entrySet();
//        Set<String> keys = map.keySet();
//        Collection<String> values = map.values();
//
//       Stream<Map.Entry<String, String>> stream = set.stream();
//       Stream<String> setStream = keys.stream();
//       Stream<String> stream1 = values.stream();
//
//
//        List list1 = map.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
//        List list2 =map.entrySet().stream().map(m -> m.getKey()).collect(Collectors.toList());
//        map.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
//
//        System.out.println(list1);
//
//        Map<String, String> map1 = new HashMap<>();
//        map.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
//
//        map.keySet();
//        map.values();
//
//
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
//        list = list.stream().filter(l -> l % 2 == 0)
//                .map(m -> m * 2)
//                .collect(Collectors.toList());
//        System.out.println(list);
//
//        List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
//        list1 = list1.stream().map(String::valueOf).filter(n -> n.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
//        System.out.println(list1);
//
//        List<Integer> list2 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
//        Set<Integer> set = new HashSet<>();
//        list2 = list2.stream().filter(n -> set.add(n)).collect(Collectors.toList());
//        System.out.println(list2);
//
//        Optional<Integer> optional = list2.stream().findFirst();
//        optional.ifPresent(System.out::println);
//        Optional<Integer> optional1 = list2.stream().filter(n -> n % 2 != 0).findAny();
//        optional1.ifPresent(System.out::println);
//
//        long count = list2.stream().count();
//        System.out.println(count);
//
//        Optional<Integer> optional2 = list2.stream().max((a, b) -> Integer.compare(a, b));
//        System.out.println("max " + optional2.get());
//
//        String input = "Java articles are Awesome";
//        Character result = input.chars()
//                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1L)
//                .map(entry -> entry.getKey())
//                .findFirst()
//                .get();
//
//        list2 = list2.stream().sorted().collect(Collectors.toList());
//
//        int[] nums = {1, 2, 3, 1};
//        Set<Integer> set1 = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//
//        System.out.println(set1);
//
//
//        Stream<Integer> stream = Stream.concat(list1.stream(), list2.stream());
//        stream.forEach(System.out::println);
//
//        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
//        integerList = integerList.stream()
//                .map(n -> n * n * n)
//                .filter(n -> n > 50)
//                .collect(Collectors.toList());
//        System.out.println(integerList);
//


        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1,2);
        map2.put(2,3);
        map2.put(3,4);
        map2.put(4,5);

        Set<Map.Entry<Integer, Integer>> mapEntrySet = map2.entrySet();
        Set<Integer> set2 = map2.keySet();
        Collection<Integer> collections = map2.values();

        List<Integer> list3 = map2.entrySet().stream().map(m -> m.getKey()).collect(Collectors.toList());
        System.out.println(list3);

        List<Integer> list4 = map2.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
        System.out.println(list4);

//        mapEntrySet.stream().map()

    }

}
