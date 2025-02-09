package com.dsa4.dp;

/**
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 * <p>
 * Also given an integer C which represents knapsack capacity.
 * <p>
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 * <p>
 * NOTE:
 * <p>
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 103
 * <p>
 * 1 <= C <= 103
 * <p>
 * 1 <= A[i], B[i] <= 103
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
 * A = [60, 100, 120]
 * B = [10, 20, 30]
 * C = 50
 * Input 2:
 * <p>
 * A = [10, 20, 30, 40]
 * B = [12, 13, 15, 19]
 * C = 10
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 220
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
 * Explanation 2:
 * <p>
 * Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
public class ZeroOneKnapsack {

    public int solve(int[] A, int[] B, int C) {

        int n = A.length;
        int[][] dp = new int[n][C+1];
        for(int j = 1; j<=C; j++) {
            if(j<B[0])
                dp[0][j]=0;
            else
                dp[0][j]=A[0];
        }

        for(int i = 1; i<n; i++) {
            for(int j = 1; j<=C; j++){
                if(j<B[i]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], A[i] + dp[i-1][j-B[i]]);
                }
            }
        }

        return dp[n-1][C];
    }

    public static void main(String[] args) {

        ZeroOneKnapsack zo = new ZeroOneKnapsack();
        int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int C = 50;
        System.out.println("Result->" + zo.solve(A, B, C));
    }
}
