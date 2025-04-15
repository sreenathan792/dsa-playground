package com.dsa4.dp;

/**
 * Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
 * <p>
 * Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length(A), length(B) <= 700
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument of input contains a string A.
 * The second argument of input contains a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer representing the answer as described in the problem statement.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = "abc"
 * B = "abc"
 * Input 2:
 * <p>
 * A = "rabbbit"
 * B = "rabbit"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Both the strings are equal.
 * Explanation 2:
 * <p>
 * These are the possible removals of characters:
 * => A = "ra_bbit"
 * => A = "rab_bit"
 * => A = "rabb_it"
 * <p>
 * Note: "_" marks the removed character.
 */
public class DistinctSubsequences {

    public int numDistinct(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first column with 1 because there's one empty subsequence in any string.
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        DistinctSubsequences ds = new DistinctSubsequences();
        String A = "rabbbit";
        String B = "rabbit";
        System.out.println("No of distinct ways to form subsequences ->" + ds.numDistinct(A, B));
    }

}
