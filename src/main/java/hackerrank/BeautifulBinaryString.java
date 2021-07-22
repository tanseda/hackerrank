package hackerrank; /**
 * Created by stan on 01/02/2021.
 * https://www.hackerrank.com/challenges/beautiful-binary-string/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulBinaryString {
    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        int index = b.indexOf("010", 0) ;
        int change = 0;
        while (index != -1) {
            change++;
            index = b.indexOf("010", index + 3) ;
        }
        return change;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
