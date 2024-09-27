package com.test.hashing;

import java.util.HashMap;

/**
 * Given an array A of N integers.
 * Find the length of the longest subarray in the array which sums to zero.
 * <p>
 * If there is no subarray which sums to zero then return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * Single argument which is an integer array A.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, -2, 1, 2]
 * Input 2:
 * <p>
 * A = [3, 2, -1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * [1, -2, 1] is the largest subarray which sums up to 0.
 * Explanation 2:
 * <p>
 * No subarray sums up to 0.
 */
public class LongestSubArrayZeroSum {

    public int solve(int[] A) {

        int n = A.length;
        int ans = 0;
        long[] prefArray = new long[n];
        prefArray[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefArray[i] = prefArray[i - 1] + A[i];
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if (prefArray[i] == 0) {
                ans = Math.max(ans, i + 1);
            } else {
                if (hm.containsKey(prefArray[i])) {
                    int startIndex = hm.get(prefArray[i]);
                    ans = Math.max(ans, (i-startIndex));
                } else {
                    hm.put(prefArray[i], i);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubArrayZeroSum lon = new LongestSubArrayZeroSum();
        int[] A = {2, 2, 1, -3, 4, 3, 1, -2, -3, 2};
        System.out.println("Result -> " + lon.solve(A));
    }
}
