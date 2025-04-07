package com.test.math;

/**
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 * <p>
 * Find the maximum value of GCD.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 2 <= N <= 105
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the maximum value of GCD.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [12, 15, 18]
 * Input 2:
 * <p>
 * A = [5, 15, 30]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 6
 * Output 2:
 * <p>
 * 15
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * If you delete 12, gcd will be 3.
 * If you delete 15, gcd will be 6.
 * If you delete 18, gcd will 3.
 * Maximum value of gcd is 6.
 * Explanation 2:
 * <p>
 * If you delete 5, gcd will be 15.
 * If you delete 15, gcd will be 5.
 * If you delete 30, gcd will be 5.
 * Maximum value of gcd is 15.
 */
public class DeleteOne {

    public static void main(String[] args) {
        int[] A = {7,21};
        DeleteOne dOne = new DeleteOne();
        System.out.println("Maximum gcd after deleting one element ->" + dOne.solve(A));
    }

    public int solve(int[] A) {

        int n = A.length;

        int[] gcdPrefix = new int[n];
        gcdPrefix[0] = A[0];
        for (int i = 1; i < n; i++) {
            gcdPrefix[i] = gcd(gcdPrefix[i - 1], A[i]);
        }

        int[] gcdSuffix = new int[n];
        gcdSuffix[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            gcdSuffix[i] = gcd(gcdSuffix[i + 1], A[i]);
        }

        if(n==2) {
            return Math.max(gcdSuffix[0], gcdSuffix[1]);
        }

        int maxGcd = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            maxGcd = Math.max(maxGcd, gcd(gcdPrefix[i - 1], gcdSuffix[i + 1]));
        }

        return maxGcd;
    }

    public int gcd(int a, int b) {

        if (a < b)
            return gcd(b, a);

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
}
