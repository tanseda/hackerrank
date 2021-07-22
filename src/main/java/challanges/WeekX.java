package challanges;

import java.util.List;
import java.util.Optional;

/**
 * Created by stan on 12/04/2021.
 */
public class WeekX {

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 3, 1, 5, 1, 7, 9);

        //Optional<Integer> number =
                list.stream()
                //.takeWhile(i -> i > 3)
                .dropWhile(i -> i > 3)
                .forEach(System.out::println);
                //.dropWhile(i -> i > 9)
//                .findFirst()
//                .or(()-> Optional.of(777));

       // System.out.println(number);
    }
}
