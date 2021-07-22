package hackerrank; /**
 * Created by stan on 27/01/2021.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DivisibleSumPairs {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        HashMap<Integer, Integer> pair = new HashMap<>();

        return 2;

    }

    static int migratoryBirds(List<Integer> arr) {
        //1 2 3 4 5 4 3 2 1 3 4
        HashMap <Integer, Integer> sightedBirdCounter = new HashMap<>();
        int freqType = 6;

        for(Integer type : arr){
            int count = sightedBirdCounter.merge(type, 1, Integer::sum);
        }

        freqType = Collections.max(sightedBirdCounter.entrySet(), Map.Entry.comparingByValue()).getKey();
        return freqType;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
