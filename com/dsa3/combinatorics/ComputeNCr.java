package com.dsa3.combinatorics;

import com.test.recursion.CountOfFactors;

/**
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
 * <p>
 * <p>
 * <p>
 * <p>
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A * B <= 106
 * <p>
 * 1 <= B <= A
 * <p>
 * 1 <= C <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is integer A ( = n).
 * The second argument given is integer B ( = r).
 * The third argument given is integer C ( = m).
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the value of nCr % m.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 5
 * B = 2
 * C = 13
 * Input 2:
 * <p>
 * A = 6
 * B = 2
 * C = 13
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The value of 5C2 % 11 is 10.
 * Explanation 2:
 * <p>
 * The value of 6C2 % 13 is 2.
 */
public class ComputeNCr {

    public int solve(int A, int B, int C) {
        // dp[n][r] stores the value of nCr
        int[][] dp = new int[A + 1][B + 1];
        for(int i = 0; i <= A; i++) {
            for(int j = 0; j <= Math.min(i, B); j++) {
                if(j == i || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // nCr = (n - 1)C(r - 1) + (n - 1)Cr
                    dp[i][j] = (dp[i - 1][j - 1] % C + dp[i - 1][j] % C) % C;
                }
            }
        }
        return dp[A][B] % C;
    }

    public static void main(String[] args) {
        ComputeNCr cn = new ComputeNCr();
        System.out.println("nCr = " + cn.solve(36, 5, 81));
    }
}
