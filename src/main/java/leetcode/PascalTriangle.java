package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stan on 08/04/2021.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> ret = solution.generate(10);

        System.out.println(ret);
    }

    public List<List<Integer>> generate(int numRows) {
        /*
        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1]]
                  1    2      3        4          5             6
        1                       0 / 1
        1 1                     1 / 2
        1 2 1                   2 / 3
        1 3 3 1                 3 / 4
        1 4 6 4 1               4 / 5
        1 5 10 10 5 1           5 / 6
        1 6 15 20 15 6 1        6 / 7
        1 7 21 35 35 21 7 1     7 / 8

        */

        List<List<Integer>> pascalTriangle = new ArrayList<>();

        if(numRows == 0) return pascalTriangle;

        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        pascalTriangle.add(prevRow);

        for(int i = 1; i < numRows ; i++){
            List<Integer> row = new ArrayList<>();
            prevRow = pascalTriangle.get(i-1);

            row.add(1);
            for(int j = 1; j < i; j++) {
                int val = prevRow.get(j-1) + prevRow.get(j);
                row.add(val);
            }

            row.add(1);

            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }
}
