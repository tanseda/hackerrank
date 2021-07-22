package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/pangrams/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pangrams {
    // Complete the pangrams function below.
    static String pangrams(String s) {
        if (s.length() < 26) {
            return "not pangram";
        }

        String lowerCase = s.toLowerCase();
        HashSet<Character> characters = new HashSet<>();
        for(int i = 0; i < lowerCase.length(); i++) {
            char val = lowerCase.charAt(i);
            if(Character.isAlphabetic(val)) {
                characters.add(val);
            }
        }

        if(characters.size() != 26) {
            return "not pangram";
        } else {
            return "pangram";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
