package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/two-characters/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ThePowerSum {
    // Complete the alternate function below.
    static int powerSum(int X, int N) {
        int retval = powerSum(X, N, 1);
        System.out.println (retval);
        return retval;
    }

    static int powerSum(int total, int power, int num) {
        int value = total - (int) Math.pow(num, power);

        System.out.println("total : " + total
                +"num : "+ num
                + "value :" + value);

        if(value < 0) return 0;
        else if(value == 0) return 1;

        return powerSum(total, power, num +1) +
                powerSum(value, power, num +1);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);
        System.out.println("result : " + result);
    }
}
