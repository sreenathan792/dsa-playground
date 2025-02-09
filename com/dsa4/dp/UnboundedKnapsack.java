package com.dsa4.dp;

/**
 * Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
 * <p>
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 1000
 * <p>
 * 1 <= |B| <= 1000
 * <p>
 * 1 <= B[i] <= 1000
 * <p>
 * 1 <= C[i] <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is the Weight of knapsack A
 * <p>
 * Second argument is the vector of values B
 * <p>
 * Third argument is the vector of weights C
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the maximum value that fills the knapsack completely
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 10
 * B = [5]
 * C = [10]
 * Input 2:
 * <p>
 * A = 10
 * B = [6, 7]
 * C = [5, 5]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * 14
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Only valid possibility is to take the given item.
 * Explanation 2:
 * <p>
 * Take the second item twice.
 */
public class UnboundedKnapsack {

    public int solve(int A, int[] B, int[] C) {

        int n = B.length;
        int[] dp = new int[A+1];
        for(int i = 1; i<=A; i++) {
            for(int j = 0; j<n; j++) {
                if(C[j]<=i) {
                    dp[i] = Math.max(dp[i], B[j] + dp[i-C[j]]);
                }
            }
        }

        return dp[A];
    }

    public static void main(String[] args) {

        UnboundedKnapsack un = new UnboundedKnapsack();
        int A = 10;
        int[] B = {6, 7};
        int[] C = {5, 5};
        System.out.println("Result->" + un.solve(A, B, C));
    }
}
