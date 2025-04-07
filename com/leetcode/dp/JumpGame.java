package com.leetcode.dp;

/**
 * <h4>55. Jump Game</h4>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {

    // Greedy Solution
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int last = n-1;
        for(int i = n-1; i>=0; i--) {

            if(i + nums[i] >= last) {
                last = i;
            }
        }

        if(last == 0)
            return true;

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,0,4};
        JumpGame jump = new JumpGame();
        System.out.println("Possiblity of reaching end -> "+ jump.canJump(nums));
    }
}
