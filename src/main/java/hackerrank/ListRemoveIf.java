package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by stan on 01/03/2021.
 */
public class ListRemoveIf {

    public static void main(String... values) {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(22);
        list.add(14);
        list.add(128);

        Integer prestoAge = 14;
        Integer dungeonMasterAge = 128;

        // The JDK developers created a rule that integer numbers from -128 to 127 will be cached.
        // This means that every variable created within this range will be cached,
        // which means that a new object won't be created in the memory heap.
        // When we use the '==' operator we are comparing if the object reference is pointing to the same object.
        // in the first comparison the condition will be false because when we use the new operator,
        // we are forcing the creation of a new object in the memory heap.
        methog();
        list.removeIf(e-> e == new Integer(12)
            || e == dungeonMasterAge
            || e == prestoAge
            || e.equals(new Integer(22)));

        System.out.println(list);


    }

    static String isValid(String s) {
//        HashMap<Character, Long> frequency = s.chars()
//                .mapToObj((c)-> (char)c)
//                .collect(
//                        Collectors.groupingBy(
//                                Function.identity(),
//                                new HashMap,
//                                Collectors.counting()
//                        )
//                );

        //{'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}

//
//        Iterator it = frequency.values().iterator();
//        it.next()
//        for(Long freq : ){
//            Math.abs(prev )
//        }
        return "";
    }

    public static void methog() {
        System.out.println("methog");
        var is = IntStream.range(1, 5);
        var avg = is.filter(i -> i % 5 == 0).average(); // line n1

        is = IntStream.range(1, 5);
        var sum = is.filter(i -> i % 2 != 0).sum(); // line n2

        is = IntStream.range(1, 5);
        var count = is.filter(i-> i % 5 == 0).count(); // line n3

        System.out.println(avg + " " + sum + " " + count);
    }
}
