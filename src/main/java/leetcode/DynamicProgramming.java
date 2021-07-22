package leetcode;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by stan on 13/04/2021.
 *
 */


public class DynamicProgramming {
    public static void main(String[] args) {
        DynamicProgramming solution = new DynamicProgramming();

        System.out.println( Math.floorDiv(9,2));
        System.out.println( Math.floorDiv(8,2));

        int array[] = { -7,1,5,3,6,4,4 };
        int max = solution.maxSubArrayDynamic(array);

        System.out.println(" maxProfit : " + max);
//        int maxProfit = solution.maxProfit(array);
//        int maxProfitWithHold = solution.maxProfitWithHold(array);
//
//        System.out.println(" maxProfit : " + maxProfit
//            + " maxProfitWithHold : " + maxProfitWithHold);

    }

    /*
        You are climbing a staircase. It takes n steps to reach the top.
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Input: n = 2
        Output: 2


        // 1                               -> 1
        // 2 2                             -> 2
        // 3 3                             -> 3
        // 4 1111, 22, 112, 211, 121       -> 5
        // 5 11111, 221, 212, 122, 1112,   -> 8
        // 6 11111, 15, 51, 24, 42,        -> 13
     */

    public int climbStairsRecursive(int n) {
        int memo [ ] = new int[n + 1];

        return climbStairs(memo, n);

    }

    public int climbStairs(int[] memo , int n) {
        if(n == 1) return 1;

        if(n == 2) return 2;

        if(memo[n] > 0) {
            return memo[n];
        }

        memo[n] = climbStairs(memo, n - 1)  + climbStairs(memo, n - 2);
        return memo[n];
    }

    public int climbStairsDynamic(int n) {
        if( n == 1)
            return 1;

        int[] steps = new int[n+1];

        steps[1] = 1;
        steps[2] = 2;

        for(int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }

    /* Min Cost Climbing Stairs
        You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
        Once you pay the cost, you can either climb one or two steps.
        You can either start from the step with index 0, or the step with index 1.

        Return the minimum cost to reach the top of the floor.
     */
    public int minCostClimbingStairs(int[] cost) {
        // cost = [10,15,20]
        // cost = [1,100,1,1,1,100,1,1,100,1]

        int f1 = cost[0], f2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int current = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = current;
        }

        return Math.min(f1, f2);
    }


    /* Best Time to Buy and Sell Stock
     https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/
    * You are given an array prices where prices[i] is the price of a given stock on the ith day.
      You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
      Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*/

    public int maxProfit(int[] prices) {

        // prices = [7,1,5,3,6,4]
        // prices = [7,6,4,3,1]

        int maxProfit = 0;
        int stockToBuy = prices[0];

        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - stockToBuy;
            maxProfit = Math.max(profit, maxProfit);

            if (prices[i] < stockToBuy) {
                stockToBuy = prices[i];
            }
        }

        return maxProfit;
    }

    /* Best Time to Buy and Sell Stock with a window of 5
     https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/
    */

    public int maxProfitWithHold(int[] prices) {

        // prices = [7,1,5,3,6,4,7,3,10]
        //
        // prices = [7,6,4,3,1]

        int stockToBuy = prices[0];
        int maxProfit = 0;

        for(int i = 5; i < prices.length; i++) {
            if (prices[i - 5] < stockToBuy) {
                stockToBuy = prices[i - 5];
            }

            int profit = prices[i] - stockToBuy;
            maxProfit = Math.max(profit, maxProfit);

        }

        return maxProfit;
    }


    /* Maximum Subarray
    https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/566/

    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

     */
    public int maxSubArrayDynamic(int[] nums) {
        // nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        /*

         */
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }

    private int[] numsArray;

    public int maxSubArrayDivideConquer(int[] nums) {
        numsArray = nums;

        // Our helper function is designed to solve this problem for
        // any array - so just call it using the entire input!
        return findBestSubarray(0, numsArray.length - 1);
    }

    private int findBestSubarray(int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        // Iterate from the middle to the beginning.
        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(bestLeftSum, curr);
        }

        // Reset curr and iterate from the middle to the end.
        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(bestRightSum, curr);
        }

        // The bestCombinedSum uses the middle element and the best
        // possible sum from each half.
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;

        // Find the best subarray possible from both halves.
        int leftHalf = findBestSubarray(left, mid - 1);
        int rightHalf = findBestSubarray(mid + 1, right);

        // The largest of the 3 is the answer for any given input array.
        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }


    /*
        House Robber
        https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/
     */
}
