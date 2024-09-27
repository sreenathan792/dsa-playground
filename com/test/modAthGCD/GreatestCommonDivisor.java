package com.test.modAthGCD;

/**
 * Given 2 non-negative integers A and B, find gcd(A, B)
 * <p>
 * GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
 * <p>
 * Note: DO NOT USE LIBRARY FUNCTIONS.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= A, B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer A.
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the gcd(A, B).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 4
 * B = 6
 * Input 2:
 * <p>
 * A = 6
 * B = 7
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 2 divides both 4 and 6
 * Explanation 2:
 * <p>
 * 1 divides both 6 and 7
 */
public class GreatestCommonDivisor {
    public int gcd(int A, int B) {
        return greatestCommonDivisor(A, B);
    }

    public int greatestCommonDivisor(int a, int b) {

        if (a < b)
            return greatestCommonDivisor(b, a);
        if (b == 0)
            return a;

        return greatestCommonDivisor(b, a % b);
    }

    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        int A = 6;
        int B = 4;
        System.out.println("GCD of " + A + " " + B + " ->" + gcd.gcd(A, B));
    }
}
