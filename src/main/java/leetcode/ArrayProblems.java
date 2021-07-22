package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stan on 13/04/2021.
 */
public class ArrayProblems {

    //https://leetcode.com/problems/degree-of-an-array/submissions/
    public int findShortestSubArray(int[] nums) {
        // nums = [1,2,2,3,2,1,3]

        HashMap<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> start = new HashMap();
        Map<Integer, Integer> end = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            start.putIfAbsent(num, i);
            end.put(num, i);
            frequency.merge(num, 1, (k, v) -> k + v);
        }

        int shortestArray = nums.length;
        int degree = Collections.max(frequency.values());

        for (int key : frequency.keySet()){
            if (frequency.get(key) == degree) {
                shortestArray = Math.min(shortestArray, end.get(key) - start.get(key) + 1);
            }
        }

        return shortestArray;
    }
}
