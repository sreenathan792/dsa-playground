package com.dsa4.dp;

import java.util.Arrays;

/**
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 * <p>
 * Also given an integer C which represents knapsack capacity.
 * <p>
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 * <p>
 * NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 500
 * <p>
 * 1 <= C, B[i] <= 106
 * <p>
 * 1 <= A[i] <= 50
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A of size N denoting the values on N items.
 * <p>
 * Second argument is an integer array B of size N denoting the weights on N items.
 * <p>
 * Third argument is an integer C denoting the knapsack capacity.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [6, 10, 12]
 * B = [10, 20, 30]
 * C = 50
 * Input 2:
 * <p>
 * A = [1, 3, 2, 4]
 * B = [12, 13, 15, 19]
 * C = 10
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 22
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
 * Explanation 2:
 * <p>
 * Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
public class ZeroOneKnapsackII {

    public int solve(int[] A, int[] B, int C) {

        int n = A.length;
        int profits = 0;
        for(int profit: A) {
            profits += profit;
        }

        int[][] dp = new int[n+1][profits+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for(int i = 1; i<=n; i++) {
            for(int p = 1; p<= profits; p++) {
                int pick = Integer.MAX_VALUE;
                if(p>=A[i-1]) {
                    pick = dp[i-1][p-A[i-1]];
                }
                if(pick != Integer.MAX_VALUE) {
                    pick += B[i-1];
                }
                int skip = dp[i-1][p];

                dp[i][p] = Math.min(skip, pick);
            }
        }

        for(int p = profits; p >= 0; p--) {
            if(dp[n][p] <= C)
                return p;
        }

        return 0;
    }

    public static void main(String[] args) {

        ZeroOneKnapsackII zo = new ZeroOneKnapsackII();
        int[] A = {6, 10, 12};
        int[] B = {10, 20, 30};
        int C = 50;
        System.out.println("Result->" + zo.solve(A, B, C));
    }
}
