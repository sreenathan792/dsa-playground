package com.dsa3.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 * <p>
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 10^9
 * <p>
 * 1 <= B <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 1, 1]
 * B = 2
 * Input 2:
 * <p>
 * A = [1, 5, 7, 10]
 * B = 8
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
 * The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 * There are 3 pairs.
 * Explanation 2:
 * <p>
 * There is only one pair, such that i = 0, and j = 2 sums up to 8.
 */

public class PairsWithSumII {

    private int MOD = 1000000007;

    public int solve(ArrayList<Integer> A, int B) {

        int n = A.size();
        int i = 0;
        int j = n - 1;
        long count = 0;

        while (i < j) {
            long sum = A.get(i) + A.get(j);
            if (sum < B) {
                i++;
            } else if (sum > B) {
                j--;
            } else {
                if (A.get(i).equals(A.get(j))) {
                    long c = j - i + 1;
                    count = (count + (c * (c - 1)) / 2) % MOD;
                    i = j + 1;
                } else {
                    long c1 = 1;
                    while (i < n - 1 && A.get(i).equals(A.get(i + 1))) {
                        c1++;
                        i++;
                    }

                    long c2 = 1;
                    while (j > 0 && A.get(j).equals(A.get(j - 1))) {
                        c2++;
                        j--;
                    }

                    count = (count % MOD + (c1 * c2) % MOD) % MOD;
                    i++;
                    j--;
                }
            }
        }

        return (int) (count % MOD);
    }

    public static void main(String[] args) {
        PairsWithSumII ps = new PairsWithSumII();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,6,6,7,9,9));
        System.out.println("Count of Pairs = " + ps.solve(arr, 13));
    }
}
