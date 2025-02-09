package com.dsa3.twopointers;

/**
 * Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.
 * <p>
 * (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
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
 * Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2]
 * B = 5
 * Input 2:
 * <p>
 * A = [1, 2]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
 * Explanation 2:
 * <p>
 * No Rectangle is valid.
 */
public class AnotherCountRectangle {

    private int MOD = 1000000007;

    public int solve(int[] A, int B) {

        int n = A.length;
        int left = 0;
        int right = n - 1;
        long count = 0;

        while (left < n && right >= 0) {

            double area = (double) A[left] * A[right];
            long maxRectangles = (long) (right + 1) % MOD;

            if (area < B) {
                count = (count % MOD + maxRectangles % MOD) % MOD;
                left++;
            } else {
                right--;
            }

        }

        if (count < 0)
            count += MOD;

        return (int) count;
    }

    public static void main(String[] args) {

        int[] A = {1, 2};
        AnotherCountRectangle cr = new AnotherCountRectangle();
        System.out.println("Count of Rectangles -> " + cr.solve(A, 5));
    }
}
