package hackerrank;

import java.io.IOException;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by stan on 18/12/2020.
 */
public class StringPAdding {
    //
    static void staircase(int n) {

        for( int i = 0 ; i < n; i++) {
            final int val = n - i -1;
            String sRepeated3 = IntStream.range(0, n)
                    .mapToObj(j -> (j < val) ? " " : "#")
                    .collect(Collectors.joining(""));

            System.out.println(sRepeated3);
        }

    }



    public static void main(String[] args) throws IOException {

        //System.out.println(String.format("%" + 5 + "s", "*"));
        staircase(5);
    }
}
