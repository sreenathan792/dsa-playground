package com.dsa4.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a strictly increasing array A of positive integers forming a sequence.
 * <p>
 * A sequence X1, X2, X3, ..., XN is fibonacci like if
 * <p>
 * <p>
 * N > =3
 * Xi + Xi+1 = Xi+2 for all i+2 <= N
 * Find and return the length of the longest Fibonacci-like subsequence of A.
 * <p>
 * If one does not exist, return 0.
 * <p>
 * NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 3 <= length of the array <= 1000
 * <p>
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the length of the longest Fibonacci-like subsequence of A.
 * If one does not exist, return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5, 6, 7, 8]
 * Input 2:
 * <p>
 * A = [1, 3, 7, 11, 12, 14, 18]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
 * Explanation 2:
 * <p>
 * The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
 * The length will be 3.
 */
public class LongestFibonacciSubsequence {

    public int solve(int[] A) {

        int n = A.length;
        int[][] dp = new int[n][n];

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(A[i], i);
        }

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                dp[j][k] = 2;
            }
        }

        int longestLength = 0;
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {

                int prevVal = A[k] - A[j];
                if (hm.containsKey(prevVal)) {

                    int i = hm.get(prevVal);
                    if (i < j) {
                        dp[j][k] = Math.max(dp[j][k], 1 + dp[i][j]);
                        longestLength = Math.max(longestLength, dp[j][k]);
                    }
                }
            }
        }

        return longestLength > 2 ? longestLength : 0;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        LongestFibonacciSubsequence lfs = new LongestFibonacciSubsequence();
        System.out.println("Length of longest fibonacci subsequence-> " + lfs.solve(A));
    }
}
