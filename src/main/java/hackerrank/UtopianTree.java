package hackerrank; /**
 * Created by stan on 29/01/2021.
 * https://www.hackerrank.com/challenges/utopian-tree/problem?h_r=next-challenge&h_v=zen
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class UtopianTree {

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        /*
        32n + 31 => 10 (5) 63
        32n + 30 => 9  (5) 62
        16n + 15 => 8
        16n + 14 => 7
        8n + 7 => 6
        8n + 6 => 5
        4n + 3 => 4
        4n + 2 => 3
        2n + 1 => 2
        2n  => 1
        */
        int result = 0;
        if (n % 2 == 0) {
            result = (int)Math.pow(2, Math.round(15/2.0)) + (int)Math.pow(2, Math.round(15/2.0)) - 1;
        } else {
            result = (int)Math.pow(2, Math.round(15/2.0)) + (int)Math.pow(2, Math.round(15/2.0)) - 2;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
