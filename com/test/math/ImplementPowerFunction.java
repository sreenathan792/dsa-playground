package com.test.math;

/**
 * Implement pow(A, B) % C.
 * In other words, given A, B and C, Find (AB % C).
 * Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
 * <p>
 * <p>
 * Problem Constraints
 * -109 <= A <= 109
 * 0 <= B <= 109
 * 1 <= C <= 109
 * <p>
 * <p>
 * Input Format
 * Given three integers A, B, C.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = 2
 * B = 3
 * C = 3
 * Input 2:
 * A = 3
 * B = 3
 * C = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * 23 % 3 = 8 % 3 = 2
 * Explanation 2:
 * 33 % 1 = 27 % 1 = 0
 */
public class ImplementPowerFunction {

    public int pow(int A, int B, int C) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        long power = power(A, B, C);
        int ans = (int) (power + C) % C;

        return ans;
    }

    public long power(int a, int n, int c) {
        if (n == 0)
            return 1;

        long x = power(a % c, n / 2, c);
        if ((n & 1) == 0) {
            return x % c * x % c;
        } else {
            return x % c * x % c * a % c;
        }
    }

    public static void main(String[] args) {
        ImplementPowerFunction pw = new ImplementPowerFunction();
        int A = 2;
        int B = 3;
        int C = 3;
        System.out.println("Power Solution ->" + pw.pow(A,B,C));
    }
}
