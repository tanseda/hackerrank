package hackerrank; /**
 * Created by stan on 18/12/2020.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class IceCreamPArlor {
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> remains = new HashMap<>();

        for (int i=0; i < cost.length; i++) {
            int remainMoney = money - cost[i];
            if (remains.containsKey( cost[i])) {
                System.out.println(remains.get(cost[i])+ " " + (i+1));
                return;
            }

            if(remainMoney > 0) {
                remains.put(remainMoney, (i+1));
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] cost = {1, 4, 5, 3, 2};
        whatFlavors(cost, 4);

        int[] cost2 = {2, 2, 4, 3};
        whatFlavors(cost2, 4);

//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        for (int tItr = 0; tItr < t; tItr++) {
//            int money = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            int n = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            int[] cost = new int[n];
//
//            String[] costItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < n; i++) {
//                int costItem = Integer.parseInt(costItems[i]);
//                cost[i] = costItem;
//            }

//            whatFlavors(cost, money);

//        }

       // scanner.close();
    }
}
