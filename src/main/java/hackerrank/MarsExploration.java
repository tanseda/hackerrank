package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsExploration {
    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int difference = 0;
        char [] SOSmessage = {'S', 'O', 'S'};
        char[] message = s.toCharArray();
        for(int i=0; i < message.length; i++) {
            difference += (message[i] != SOSmessage[i % 3]) ? 1 : 0;
        }
        return difference;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
