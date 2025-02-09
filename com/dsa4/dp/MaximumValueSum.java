package com.dsa4.dp;

import com.dsa4.heaps.MishaAndCandies;

/**
 * You are given an array A of N integers and three integers B, C, and D.
 * <p>
 * You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * -10000 <= A[i], B, C, D <= 10000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an array A
 * Second argument is an integer B
 * Third argument is an integer C
 * Fourth argument is an integer D
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 5, -3, 4, -2]
 * B = 2
 * C = 1
 * D = -1
 * Input 2:
 * <p>
 * A = [3, 2, 1]
 * B = 1
 * C = -10
 * D = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 18
 * Output 2:
 * <p>
 * -4
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * If you choose i = 2, j = 2, and k = 3 then we will get
 * A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
 * Explanation 2:
 * <p>
 * If you choose i = 1, j = 3, and k = 3 then we will get
 * A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
 */
public class MaximumValueSum {

    public int solve(int[] A, int B, int C, int D) {

        int n = A.length;
        int[][] dp = new int[n][3];

        // Initialize dp array
        dp[0][0] = B * A[0];
        dp[0][1] = B * A[0] + C * A[0];
        dp[0][2] = B * A[0] + C * A[0] + D * A[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], B * A[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i][0] + C * A[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i][1] + D * A[i]);
        }

        // The answer will be stored in dp[n-1][2]
        return dp[n-1][2];
    }

    public static void main(String[] args) {
        int[] A = {1, 5, -3, 4, -2};
        MaximumValueSum max = new MaximumValueSum();
        System.out.println("Maximum Value Sum -> " + max.solve(A, 2, 1, -1));
    }
}
