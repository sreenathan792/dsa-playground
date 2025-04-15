package com.dsa3.twopointers;

import java.util.Arrays;

/**
 * Given an one-dimensional unsorted array A containing N integers.
 * <p>
 * You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.
 * <p>
 * Return 1 if any such pair exists else return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * -103 <= A[i] <= 103
 * -105 <= B <= 105
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A of size N.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if any such pair exists else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [5, 10, 3, 2, 50, 80]
 * B = 78
 * Input 2:
 * <p>
 * A = [-10, 20]
 * B = 30
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Pair (80, 2) gives a difference of 78.
 * Explanation 2:
 * <p>
 * Pair (20, -10) gives a difference of 30 i.e 20 - (-10) => 20 + 10 => 30
 */
public class PairWithGivenDifference {

    public int solve(int[] A, int B) {

        Arrays.sort(A);
        int n = A.length;
        if (n < 2)
            return 0;
        int low = 0;
        int high = low + 1;

        while (high < n && low < n) {

            if (high != low && (A[high] - A[low] == B || A[low] - A[high] == B)) {
                return 1;
            }
            if (A[high] - A[low] < B) {
                high++;
            } else {
                low++;
            }

        }

        return 0;
    }

    public static void main(String[] args) {

        int[] A = {20, 500, 1000, 200};
        PairWithGivenDifference pw = new PairWithGivenDifference();
        System.out.println("Is Pair Present -> " + pw.solve(A, 0));
    }
}
