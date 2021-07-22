package leetcode;

/**
 * Created by stan on 13/04/2021.
 */
public class Sorts {

    //Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    //
    //The number of elements initialized in nums1 and nums2 are m and n respectively.
    //You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]

        */
        int i = m - 1, j = n -1;
        int index = m + n - 1;

        while ( i >= 0 && j >= 0) {
            if ( nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }

        while (j >= 0){
            nums1[index--] = nums2[j--];
        }
    }

    //https://leetcode.com/problems/first-bad-version/
    //First Bad Version
    //Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
    //which causes all the following ones to be bad.


    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    boolean isBadVersion(int version){
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while( left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    //https://leetcode.com/problems/search-insert-position/submissions/
    //Given a sorted array of distinct integers and a target value,
    //return the index if the target is found.
    //If not, return the index where it would be if it were inserted in order.
    public int searchInsert(int[] nums, int target) {
        // Input: nums = [1,3,5,6], target = 5
        // Output: 2

        // 1 3 5 6 7
        // left  right   mid    val
        //  1     4      2      5
        //  0     2      1      3
        //  2     2


        int left = 0;
        int right = nums.length ;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
