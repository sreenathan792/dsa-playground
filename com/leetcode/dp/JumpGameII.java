package com.leetcode.dp;

/**
 * <h4>45. Jump Game II</h4>
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGameII {

    public int jump(int[] nums) {

        int maxReach = 0;
        int lastJumpMax = 0;
        int jumps = 0;
        int n = nums.length;

        if (n == 1)
            return 0;

        for (int i = 0; i < n - 1; i++) {

            maxReach = Math.max(maxReach, i + nums[i]);
            if (lastJumpMax <= i) {
                lastJumpMax = maxReach;
                jumps++;

                if (maxReach >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 0, 1, 4};
        JumpGameII jump = new JumpGameII();
        System.out.println("Minimum steps of reaching end -> " + jump.jump(nums));
    }
}
