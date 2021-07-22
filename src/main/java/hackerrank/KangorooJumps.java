package hackerrank;

import java.io.*;
import java.util.*;

public class KangorooJumps {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // y is jump count so y is integer
        // x1 + y * v1 = x2 + y * v2
        // x2 + y * v2 - (x1 + y * v1)= 0
        // x2 - x1 + y * (v2 -v1) = 0
        // x1 - x2 = y * (v2 -v1)
        //(x1 - x2) % (v2 - v1) == 0

        if( ((x2 - x1) * (v2 - v1) < 0) && (x1 - x2) % (v2 - v1) == 0 )
            return ("YES");
        else
            return ("NO");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
