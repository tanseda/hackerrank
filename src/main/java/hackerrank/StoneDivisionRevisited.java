package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by stan on 12/02/2021.
 */
public class StoneDivisionRevisited {
    /*
    * 12
      2 3 4

      6
    * */

    static long [] queries;

    static List<Integer> minArray = new ArrayList<>();
    static List<Integer> kFactorization(int n, List<Integer> dividers, int startPoint
    ){
        List<Integer> ret = new ArrayList<>();
        if (n <= 1) {
            ret.add(1);
            return ret;
        }

        for(Integer divider: dividers) {
            if (n % divider != 0){
                continue;
            }
            int divided = n / divider;
            ret.add(n);
            ret.addAll(kFactorization(divided, dividers, startPoint ));
            if(startPoint == n) {
                Collections.reverse(ret);
                if(minArray.size()==0 || minArray.size() > ret.size()) {
                    minArray = ret;
                } else if(minArray.size() == ret.size()) {
                    int i = 0 ;
                    for(i = 0; i < ret.size(); i++) {
                        if(ret.get(i) > minArray.get(i))
                            break;
                    }
                    if(i == ret.size()) {
                        minArray = ret;
                    }
                }
            }
        }

        return ret;
    }


    static long stoneDivision(long n, long[] s) {
        queries = s;
        int[]A  = new int[5];
        int b =123;
        List<Integer> dividers =   Arrays.stream(A)
                .filter(it -> ((b % it) == 0))
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return stoneDivision(n, new HashMap<>());
    }

    static long stoneDivision(long n, HashMap<Long, Long> map) {
        if(n <= 1) {
            return 0;
        }

        if(map.containsKey(n)) {
            return map.get(n);
        }
        long max = 0;

        for(long query: queries) {
            if(n % query != 0 || n == query) {
                continue;
            }
            long numberOfPiles = n / query;
            long sum = (stoneDivision(query, map) * numberOfPiles) + 1;
            max = Math.max(sum, max);
        }

        map.put(n, max);
        return max;
    }

    public static void main(String[] args) {
//       Scanner scn = new Scanner(System.in);
 //

//            long[] querySet = new long[sizeOfQuerySet];
//
//            for (int j = 0; j < sizeOfQuerySet; j++) {
//                querySet[j] = scn.nextLong();
//            }

            long[] querySet = {2, 3, 4};
            //1
            //12 3
            //2 3 4
            long result = stoneDivision(12, querySet);
            System.out.println(result);
            //System.out.println(solve(initialPile, querySet, new HashMap<>()));
//        }//       scn.close();
    }
}
