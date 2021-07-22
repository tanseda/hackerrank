package hackerrank; /**
 * Created by stan on 28/01/2021.
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?h_r=next-challenge&h_v=zen
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> board = new ArrayList<>();
        HashMap<Integer, Integer> rankedBoard = new HashMap<>();

        int rank = 1;
        for(int i = 0; i < ranked.size(); i++ ) {
            Integer val = rankedBoard.putIfAbsent(ranked.get(i), rank);
            if(val == null) {
                rank++;
            }
        }

        int j = ranked.size() - 1;
        for(int i = 0; i < player.size(); i++) {
            boolean added = false;
            for (; j >= 0 ; j--) {
                if (player.get(i) < ranked.get(j)) {
                    board.add(rankedBoard.get(ranked.get(j)) + 1);
                    added = true;
                    break;
                } else if (player.get(i) == ranked.get(j)) {
                    board.add(rankedBoard.get(ranked.get(j)));
                    added = true;
                    break;
                }
            }

            if(j <= 0 && !added) {
                board.add(1);
            }
        }

        return board;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);


//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
