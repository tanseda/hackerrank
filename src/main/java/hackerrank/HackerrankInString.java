package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem?h_r=next-challenge&h_v=zen
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerrankInString {
    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        char[] hackerrank = {'h', 'a', 'c','k','e','r', 'r', 'a', 'n', 'k'};

        int j = 0;
        for(int i = 0; i < s.length() && j < hackerrank.length; i++) {
            if (s.charAt(i) == hackerrank[j]) {
                j++;
            }
        }

        String retval = (j == hackerrank.length) ? "YES" : "NO";
        return retval;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
