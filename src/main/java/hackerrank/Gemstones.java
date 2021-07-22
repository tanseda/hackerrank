package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/gem-stones/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Gemstones {
    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        char[] firstStone = arr[0].toCharArray();
        HashSet<Character> gemstones = new HashSet<>();

        for(int i = 0; i < firstStone.length; i++) {
            int count = 1;
            for(int j = 1; j < arr.length; j++) {
                if(arr[j].contains(Character.toString(firstStone[i]))){
                    count++;
                }
            }
            if(count == arr.length ) {
                gemstones.add(firstStone[i]);
            }
        }

        return gemstones.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
