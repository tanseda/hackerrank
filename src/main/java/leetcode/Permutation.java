package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by stan on 28/04/2021.
 */
public class Permutation {
    List<List<Integer>> solution = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {

        // nums = [1,2,3]
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        /*
            1,
            (2,3)   (3,2)
                (3)     (2)

            HashSet(2, 3)
        */
        Set<Integer> set = (HashSet<Integer>) Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        return solution;
    }

    public void backtrack(int[] nums, HashSet<Integer> set, List<Integer> perm) {
        if (perm.size() == nums.length) {
            solution.add(perm);
            return;
        }

        for (Integer val : set) {
            perm.add(val);

            HashSet<Integer> set2 = (HashSet<Integer>) set.stream()
                    .filter(it -> val != it)
                    .collect(Collectors.toSet());

            backtrack(nums, set2, perm );

            perm.remove(perm.size() - 1);
        }
    }

    public static void main(String[] args) {

    }

}
