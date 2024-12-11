package com.dsa3.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.
 * <p>
 * Since the number of subarrays could be large, return value % 109 +7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is an Array A, having N integers.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the number of subarrays of A, that have unique elements.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 1, 3]
 * Input 2:
 * <p>
 * A = [2, 1, 2]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4
 * Output 1:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Subarrays of A that have unique elements only:
 * [1], [1], [1, 3], [3]
 * Explanation 2:
 * <p>
 * Subarrays of A that have unique elements only:
 * [2], [1], [2, 1], [1, 2], [2]
 */
public class CountUniqueElemSubArrays {

    private int MOD = 1000000007;

    public int solve(int[] A) {

        int n = A.length;
        int l = 0;
        int ans = 0;
        Set<Integer> hs = new HashSet<>();
        for (int r = 0; r < n; r++) {

            while (hs.contains(A[r])) {
                hs.remove(A[l]);
                l++;
            }
            hs.add(A[r]);
            ans = ((ans % MOD) + (r - l + 1) % MOD) % MOD;
        }

        return ans % MOD;
    }

    public static void main(String[] args) {

        CountUniqueElemSubArrays cnt = new CountUniqueElemSubArrays();
        int[] A = {1, 1, 3};
        System.out.println("Count of Subarrays with unique elements -> " + cnt.solve(A));
    }
}
