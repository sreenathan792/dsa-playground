package com.leetcode.dp;

/**
 * <h4>322. Coin Change</h4>
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[] minCoins = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCoins[i] = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                int coin = coins[j];

                if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                }
            }
        }

        if (minCoins[amount] == Integer.MAX_VALUE)
            minCoins[amount] = -1;

        return minCoins[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange cc = new CoinChange();
        System.out.println("Minimum Coins needed ->" + cc.coinChange(coins, amount));
    }
}
