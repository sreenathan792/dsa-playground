package com.leetcode.arrays;

/**
 * <h4>1752. Check if Array Is Sorted and Rotated</h4>
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
 * <p>
 * There may be duplicates in the original array.
 * <p>
 * Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
 * Example 2:
 * <p>
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 */
public class CheckSortedRotated {

    public boolean check(int[] nums) {

        int n = nums.length;
        int pos = 1;
        while(pos<n && nums[pos]>=nums[pos-1]) {
            pos++;
        }

        if(pos == n || pos == n-1) return true;
        if(nums[pos]>nums[0]) return false;

        pos++;
        while(pos<n && nums[pos]>=nums[pos-1] && nums[pos]<=nums[0]) {
            pos++;
        }

        return pos==n;
    }

    public static void main(String[] args) {
        CheckSortedRotated csr = new CheckSortedRotated();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Sorted and Rotated-> " + csr.check(nums));
    }
}
