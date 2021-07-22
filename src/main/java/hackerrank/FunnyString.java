package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/funny-string/problem?h_r=next-challenge&h_v=zen
 */
public class FunnyString {
    // Complete the funnyString function below.
    static String funnyString(String s) {
        int[] absoluteDiff = new int[s.length()-1];
        char[] charArray = s.toCharArray();

        for(int i = 0; i < charArray.length - 1; i++) {
            absoluteDiff[i] = Math.abs(charArray[i] - charArray[i + 1]);
        }
        int i = 0;
        boolean funny = true;
        for(; i < absoluteDiff.length / 2; i++) {
            if(absoluteDiff[i] != absoluteDiff[absoluteDiff.length - i - 1]) {
                funny = false;
                break;
            }
        }

        return funny ? "Funny" : "Not Funny";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
