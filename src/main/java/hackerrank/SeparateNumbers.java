package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SeparateNumbers {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        String result = "";
        for(int i = 1; i <= s.length() / 2; i++){
            long number = Long.parseLong(s.substring(0, i));
            long expectedNextNumber = number + 1;
            String expectedNextNumberInString = String.valueOf(expectedNextNumber);
            int j = i + expectedNextNumberInString.length();
            String nextNumber = s.substring(i, j);
            while ( j < s.length() && nextNumber.equals(expectedNextNumberInString)) {
                expectedNextNumber = expectedNextNumber + 1;
                expectedNextNumberInString = String.valueOf(expectedNextNumber);
                if(j + expectedNextNumberInString.length() > s.length())
                    break;
                nextNumber = s.substring(j, j + expectedNextNumberInString.length());
                j += expectedNextNumberInString.length();
            }

            if(j >= s.length() && nextNumber.equals(expectedNextNumberInString)) {
                System.out.println ("YES " + number);
                return;
            }
        }
        System.out.println ( "NO");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
