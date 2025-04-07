package com.leetcode.dp;

/**
 * <h4>70. Climbing Stairs</h4>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public class ClimbStairs {

    public int climbStairs(int n) {

        if(n<2) {
            return 1;
        }

        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;

        for(int i=2; i<=n; i++) {
            ways[i] = ways[i-1]+ways[i-2];
        }

        return ways[n];
    }

    public static void main(String[] args) {

        int n = 4;
        ClimbStairs climb = new ClimbStairs();
        System.out.println("Ways to climb "+ n +" stairs -> "+ climb.climbStairs(n));
    }

}
