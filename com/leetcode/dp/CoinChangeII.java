package com.leetcode.dp;

/**
 * <h4>518. Coin Change II</h4>
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 * <p>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 * <p>
 * Input: amount = 10, coins = [10]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] ways = new int[n][amount + 1];

        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                ways[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notTake = ways[i - 1][j];
                int take = 0;
                if (coins[i] <= j) {
                    take = ways[i][j - coins[i]];
                }
                ways[i][j] = take + notTake;
            }
        }

        return ways[n - 1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChangeII ch = new CoinChangeII();
        System.out.println("Ways to make change -> " + ch.change(amount, coins));
    }
}
