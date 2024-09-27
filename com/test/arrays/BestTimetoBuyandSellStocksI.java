package com.test.arrays;

/**
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Return the maximum possible profit.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= A.size() <= 700000
 * <p>
 * <p>
 * <p>
 * 1 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and the only argument is an array of integers, A.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer, representing the maximum possible profit.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = [1, 2]
 * Input 2:
 * <p>
 * A = [1, 4, 5, 2, 4]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * 1
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * Buy the stock on day 0, and sell it on day 1.
 * Explanation 2:
 * <p>
 * Buy the stock on day 0, and sell it on day 2.
 */
public class BestTimetoBuyandSellStocksI {

    /** Not optimal - O(n2) -> TLE*/
    public int maxProfitN2(final int[] A) {
        int maxProfit = 0;
        int n = A.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j<n; j++) {
                int profit = A[j] - A[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public int maxProfit(final int[] A) {
        int maxProfit = 0;
        int n = A.length;
        int sum = 0;
        int[] maxR = new int[n];
        maxR[n-1] = A[n-1];
        for(int i = n-2; i>=0; i--) {
            maxR[i] = Math.max(A[i], maxR[i+1]);
        }

        for(int i = 0; i < n; i++) {
            int profit = maxR[i] - A[i];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStocksI bs = new BestTimetoBuyandSellStocksI();
        int[] A = {1, 4, 5, 2, 4};
        System.out.println("Best time to buy and sell stocks = " + bs.maxProfit(A));
    }
}
