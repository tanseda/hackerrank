package hackerrank; /**
 * Created by stan on 29/01/2021.
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CaesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        char[] sentence = s.toCharArray();

        for(int i = 0; i < sentence.length; i++) {
            char start = ' ';

            if(Character.isLowerCase(sentence[i])) {
                start = 'a';
            } else if (Character.isUpperCase(sentence[i])){
                start = 'A';
            }

            if(start != ' ') {
                int val = (sentence[i] - start + k) % 26;
                sentence[i] = (char)(start + val);
            }

        }

        return String.valueOf(sentence);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}