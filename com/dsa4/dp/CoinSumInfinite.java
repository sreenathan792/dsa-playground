package com.dsa4.dp;

/**
 * You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
 * <p>
 * NOTE:
 * <p>
 * Coins in set A will be unique. Expected space complexity of this problem is O(B).
 * The answer can overflow. So, return the answer % (106 + 7).
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 500
 * 1 <= A[i] <= 1000
 * 1 <= B <= 50000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A representing the set.
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the number of ways.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3]
 * B = 4
 * Input 2:
 * <p>
 * A = [10]
 * B = 10
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The 4 possible ways are:
 * {1, 1, 1, 1}
 * {1, 1, 2}
 * {2, 2}
 * {1, 3}
 * Explanation 2:
 * <p>
 * There is only 1 way to make sum 10.
 */
public class CoinSumInfinite {

    private int MOD = 1000007;
    public int coinchange2(int[] A, int B) {

        int n = A.length;
        int[] dp = new int[B+1];
        dp[0] = 1;

        for(int j = 0; j<n; j++) {
            for(int i = 1; i<=B; i++) {
                if(i-A[j] >= 0) {
                    dp[i] = (dp[i] + dp[i-A[j]]) % MOD;
                }
            }

        }

        return dp[B];
    }

    public static void main(String[] args) {

        CoinSumInfinite cn2 = new CoinSumInfinite();
        int[] A = {1, 2, 3, 4};
        int B = 5;
        System.out.println("No of ways ->" + cn2.coinchange2(A, B));
    }
}
