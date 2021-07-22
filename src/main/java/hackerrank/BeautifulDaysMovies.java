package hackerrank; /**
 * Created by stan on 29/01/2021.
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem?h_r=next-challenge&h_v=zen
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BeautifulDaysMovies {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        long count =  IntStream.range(i, j + 1)
                .filter(it-> isBeatifulDay(it, k))
                .count();

        return (int) count;
    }
    static boolean isBeatifulDay(int i, int k) {
        int reversedDay = reversedDay(i);

        return (Math.abs(reversedDay - i) % k == 0);
    }

    static int reversedDay(int  i) {
        int reversedDay = 0;

        while (i != 0) {
            reversedDay = reversedDay * 10 + i % 10;
            i = i / 10;
        }

        // StringBuilder day = new StringBuilder(Integer.toString(i));
        // int reversedDay = Integer.parseInt(day.reverse().toString(), 10);

        return reversedDay;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}