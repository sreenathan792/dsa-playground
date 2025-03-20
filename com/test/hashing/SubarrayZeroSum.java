package com.test.hashing;

import java.util.HashSet;

/**
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 * <p>
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * -10^9 <= A[i] <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return whether the given array contains a subarray with a sum equal to 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [4, -1, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * No subarray has sum 0.
 * Explanation 2:
 * <p>
 * The subarray [-1, 1] has sum 0.
 */
public class SubarrayZeroSum {
    public int solve(int[] A) {

        int n = A.length;
        long[] prefArr = new long[n];
        prefArr[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefArr[i] = prefArr[i - 1] + A[i];
        }

        HashSet<Long> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (prefArr[i] == 0) {
                return 1;
            }
            hs.add(prefArr[i]);
        }

        if (hs.size() < n) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        SubarrayZeroSum saZ = new SubarrayZeroSum();
        int[] A = {4, 1, -1};
        System.out.println("Result -> " + saZ.solve(A));
    }
}
