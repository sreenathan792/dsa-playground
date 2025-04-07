package com.dsa4.dp;

/**
 * As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).
 * <p>
 * NOTE:
 * <p>
 * Each dish is supposed to be eaten by only one person. Sharing is not allowed.
 * <p>
 * Each friend can take any dish unlimited number of times.
 * <p>
 * There always exists a dish with filling capacity 1 so that a solution always exists.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * |A| <= 1000
 * <p>
 * |B| <= 1000
 * <p>
 * |C| <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First Argument is vector A, denoting eating capacities
 * <p>
 * Second Argument is vector B, denoting filling capacities
 * <p>
 * Third Argument is vector C, denoting cost
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a single integer, the answer to the problem
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [2, 4, 6]
 * B = [2, 1, 3]
 * C = [2, 5, 3]
 * <p>
 * Input 2:
 * <p>
 * A = [2]
 * B = [1]
 * C = [2]
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 12
 * <p>
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
 * So 2 + 2*2 + 3*2 = 12.
 * <p>
 * Explanation 2:
 * <p>
 * Only way is to take 2 dishes of cost 2, hence 4.
 */
public class TusharsBirthdayParty {

    public int solve(final int[] A, final int[] B, final int[] C) {

        int ans = 0;
        for(int eachCapacity : A) {
            ans += minCostUnboundedKnapsack(B,C,eachCapacity);
        }

        return ans;
    }

    public int minCostUnboundedKnapsack(int[] B, int[] C, int W) {

        int[] dp = new int[W+1];
        dp[0] = 0;
        for(int i = 1; i<=W; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        int n = B.length;
        for(int i = 1; i<=W; i++) {

            for(int j = 0; j<n; j++) {
                if(B[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-B[j]] + C[j]);
                }
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        TusharsBirthdayParty tb = new TusharsBirthdayParty();
        int[] A = {2, 4, 6};
        int[] B = {2, 1, 3};
        int[] C = {2, 5, 3};

        System.out.println("Total minimum cost -> " + tb.solve(A,B,C));

    }

}
