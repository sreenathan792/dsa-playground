package com.dsa3.primenumbers;

import java.util.Arrays;

/**
 * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 * <p>
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is a string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the rank of the given string.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = "acb"
 * Input 2:
 * <p>
 * A = "a"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Given A = "acb".
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank of A is 2.
 * Explanation 2:
 * <p>
 * Given A = "a".
 * Rank is clearly 1.
 */
public class SortedPermutationRank {

    private int MOD = 1000003;
    public int findRank(String A) {

        char[] chArray = A.toCharArray();
        int n = chArray.length;
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i< n; i++) {
            factorial[i] = (factorial[i-1] * i) % MOD;
        }

        int ans = 1;
        for(int i = 0; i<n; i++) {
            int count = 0;
            for(int j = i+1; j<n; j++) {
                if(chArray[j] < chArray[i])
                    count++;
            }

            ans = (ans + (count * factorial[n-i-1]) % MOD) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        SortedPermutationRank spr = new SortedPermutationRank();
        System.out.println("Rank = " + spr.findRank("acb"));
    }
}
