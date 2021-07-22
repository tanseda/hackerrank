package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by stan on 17/12/2020.
 */
public class LargestRectangle {
    static long largestRectangle(int[] h) {
        long maxSize = Long.MIN_VALUE;

        Deque<Integer> heights = new ArrayDeque<>();
        Deque<Integer> positions = new ArrayDeque<>();

        for(int i=0; i < h.length; i++) {
            if ( heights.isEmpty() || h[i] > heights.peekLast()) {
                heights.addLast(h[i]);
                positions.addLast(i);
            } else if ( h[i] < heights.peekLast()) {
                int position = i;
                while(!heights.isEmpty() && h[i] < heights.peekLast()) {
                    position = positions.peekLast();
                    long size = heights.pollLast() * (i - positions.pollLast());
                    maxSize = Math.max(size, maxSize);
                }
                heights.addLast(h[i]);
                positions.addLast(position);
            }
        }

        while(!heights.isEmpty()) {
            long size = heights.pollLast() * (h.length - positions.pollLast());
            maxSize = Math.max(size, maxSize);
        }

        return maxSize;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("main");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < h.length; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        System.out.println(result);
    }
}
