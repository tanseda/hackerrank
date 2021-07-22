package hackerrank; /**
 * Created by stan on 28/01/2021.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int turn = (p/2) + 1;

        int fromFront = turn - 1;
        int fromBack = (n/2) +1  - turn;

        return Math.min(fromFront, fromBack) ;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
