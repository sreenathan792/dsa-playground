package com.test.hashing;

import java.util.HashMap;

/**
 * Given an array A of N integers.
 * <p>
 * Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
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
 * A = [1, -1, -2, 2]
 * Input 2:
 * <p>
 * A = [-1, 2, -1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
 * Explanation 2:
 * <p>
 * The subarray with zero sum is [-1, 2, -1].
 */
public class CountSubArrayZeroSum {

    private int MOD = 1000000007;

    public int solve(int[] A) {

        int n = A.length;
        long[] pfSum = new long[n];
        pfSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            pfSum[i] = A[i] + pfSum[i - 1];
        }

        long count = 0;
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, 1);
        for (int i = 0; i < n; i++) {
            if (hm.get(pfSum[i]) != null) {
                count = (count % MOD + hm.get(pfSum[i]) % MOD) % MOD;
                hm.put(pfSum[i], hm.get(pfSum[i]) + 1);
            } else {
                hm.put(pfSum[i], 1);
            }
        }

        return (int) count;
    }

    public static void main(String[] args) {
        CountSubArrayZeroSum csaZ = new CountSubArrayZeroSum();
        int[] A = {1, -1, -2, 2};
        System.out.println("Result -> " + csaZ.solve(A));
    }
}
