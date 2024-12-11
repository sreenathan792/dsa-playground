package com.dsa3.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of N integers.
 * Find the length of the longest subarray in the array which sums to zero.
 * <p>
 * If there is no subarray which sums to zero then return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * <p>
 * Single argument which is an integer array A.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, -2, 1, 2]
 * Input 2:
 * <p>
 * A = [3, 2, -1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * [1, -2, 1] is the largest subarray which sums up to 0.
 * Explanation 2:
 * <p>
 * No subarray sums up to 0.
 */
public class LongestSubArrayZeroSum {

    public int solve(int[] A) {

        int ans = 0;
        int n = A.length;
        long[] prefSum = new long[n];
        prefSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + A[i];
        }

        Map<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if (prefSum[i] == 0)
                ans = Math.max(ans, i + 1);

            if (mp.containsKey(prefSum[i])) {
                int index = mp.get(prefSum[i]);
                ans = Math.max(ans, i - index);

            } else {
                mp.put(prefSum[i], i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubArrayZeroSum lng = new LongestSubArrayZeroSum();
        int[] A = {1, -2, 1, 2};
        System.out.println("Length of longest subarray -> " + lng.solve(A));
    }
}
