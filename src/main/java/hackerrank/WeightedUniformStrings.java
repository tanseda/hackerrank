package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/weighted-uniform-string/problem?h_r=next-challenge&h_v=zen
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
/*
        aaabbbbcccddd
        9  YES
        7  NO
        8  YES
        12 YES
        5 NO
        */

        char[] charArray = s.toCharArray();
        Set<Integer> num = new HashSet<>();
        int lastWeightedChar = 0, count = 0;
        for(int i = 0; i < charArray.length; i++){
            int weightedChar = charArray[i] - 'a' + 1;
            if(lastWeightedChar == weightedChar) {
                count++;
            } else {
                lastWeightedChar = weightedChar;
                count = 1;
            }
            num.add(count * weightedChar);
        }

        String [] result = new String[queries.length];
        for(int i = 0; i < queries.length; i++) {
            result[i] = (num.contains(queries[i])) ? "Yes" : "No";
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
