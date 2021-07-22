package hackerrank; /**
 * Created by stan on 28/01/2021.
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 */

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PickingNumbers {

    public static void main(String[] args) throws IOException {
        System.out.println("12323");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = pickingNumber2s(a);
        System.out.println("result : " + result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }

    public static int pickingNumbers(List<Integer> a) {
        int frequency[] = new int[101];
        int result = Integer.MIN_VALUE;

        //4 6 5 3 3 1

        /*1 2 3 4 5 6 7
          1   2 1 1 1
        */
        for (int i = 0; i < a.size(); i++) {
            int index = a.get(i);
            frequency[index]++;

            if (result < frequency[index - 1] + frequency[index]) {
                result = frequency[index - 1] + frequency[index];
            }

            if (result < frequency[index] + frequency[index + 1]) {
                result = frequency[index] + frequency[index + 1];
            }
        }
        return result;
    }

    public static int pickingNumber2s(List<Integer> a) {
        int result = 1;
        Collections.sort(a);

        int min=a.get(0), count = 1;
        for(int i = 1; i < a.size(); i++) {
            if((a.get(i) - a.get(i-1)) <= 1 && a.get(i)-min <= 1) {
                count++;
                result = Math.max(result, count);
            } else{
                min = a.get(i);
                count = 1;
            }
        }


        return result;
    }
}
