package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by stan on 11/02/2021.
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 */

public class RecursiveDigitSum {
    private static final Scanner scanner = new Scanner(System.in);

    static int superDigit(String n, int k) {
        long total = 0;
        if (n.length() == 1 && k == 1)
            return Integer.parseInt(n);

        for (int i = 0; i < n.length(); i++) {
            total += Character.getNumericValue(n.charAt(i));
        }
        total *= k;
        return superDigit(Long.toString(total), 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
