package com.dsa4.dp;


/**
 * Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
 * However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
 * <p>
 * Return the maximum possible sum.
 * <p>
 * Note: You are allowed to choose more than 2 numbers from the grid.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 20000
 * 1 <= A[i] <= 2000
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and the only argument of input contains a 2d matrix, A.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer, representing the maximum possible sum.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [
 * [1]
 * [2]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [1, 2, 3, 4]
 * [2, 3, 4, 5]
 * ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 8
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * We will choose 2 (From 2nd row 1st column).
 * Explanation 2:
 * <p>
 * We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).
 */
public class MaxSumWithoutAdjacentElements {

    public int adjacent(int[][] A) {

        int n = A[0].length;
        int[] maxArr = new int[n];

        //Convert to a single max array of 1XN
        for(int i = 0; i<n; i++) {
            maxArr[i] = Math.max(A[0][i], A[1][i]);
        }

        if(n == 1)
            return maxArr[0];

        int[] dp = new int[n];
        dp[n-1] = Math.max(0, maxArr[n-1]); //Not Take = 0, Take = Current element
        dp[n-2] = Math.max(dp[n-1], maxArr[n-2]); //Not Take = previous dp value, Take = Current element

        if(n>2) {
            for(int i = n-3; i>=0; i--) {
                dp[i] = Math.max(dp[i+1], maxArr[i] + dp[i+2]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        int[][] A = {{28}, {10}};
        MaxSumWithoutAdjacentElements max = new MaxSumWithoutAdjacentElements();
        System.out.println("Result->" + max.adjacent(A));
    }

}
