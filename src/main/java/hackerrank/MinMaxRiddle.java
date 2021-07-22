package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by stan on 17/12/2020.
 */
public class MinMaxRiddle {

    static long[] riddle(long[] arr) {
        int N = arr.length;
        long[] result = new long[N];
        long[] span = new long[N];

        Deque<Integer> deckIndexes = new ArrayDeque<>();
        deckIndexes.push(-1);

        // count number of next greater elements to the left
        for (int i = 0; i < N; i++) {
            while (!deckIndexes.isEmpty() && deckIndexes.peek()!=-1 && arr[deckIndexes.peek()] >= arr[i]) {
                deckIndexes.pop();
            }

            span[i] = i - deckIndexes.peek() - 1;

            deckIndexes.push( i);
        }

        // count number of next greater elements to the right
        deckIndexes.clear();
        deckIndexes.push(N);
        for (int i = N - 1; i >= 0; i--) {
            while (!deckIndexes.isEmpty()&& deckIndexes.peek()!=N  && arr[deckIndexes.peek()] >= arr[i]) {
                deckIndexes.pop();
            }

            span[i] += deckIndexes.peek() - i - 1;
            deckIndexes.push( i);
        }

        // fill results
        for (int i = 0; i < N; i++) {
            result[(int) span[i]] = Math.max(result[(int) span[i]], arr[i]);
        }

        // fill the gaps
        for (int i = N - 2; i >= 0; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        //long[] arr = { 3, 5, 4, 7, 6, 2};
        long[] res = riddle(arr);

        Arrays.stream(res).forEach(i -> System.out.print( i + " "));

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
