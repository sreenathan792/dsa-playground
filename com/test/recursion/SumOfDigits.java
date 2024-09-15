package com.test.recursion;

/**
 * Given a number A, we need to find the sum of its digits using recursion.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 109
 * <p>
 * <p>
 * Input Format
 * The first and only argument is an integer A.
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the sum of digits of the number A.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 46
 * Input 2:
 * <p>
 * A = 11
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Sum of digits of 46 = 4 + 6 = 10
 * Explanation 2:
 * <p>
 * Sum of digits of 11 = 1 + 1 = 2
 */
public class SumOfDigits {

    public int solve(int A) {
        return sum(A,0);
    }

    public int sum(int n, int sum) {
        if(n==0)
            return sum;
        else
            return sum(n/10, (sum+n%10));
    }

    public static void main(String[] args) {
        SumOfDigits sd = new SumOfDigits();
        int A = 123;
        System.out.println("Sum of Digits  of " + A + " ->" + sd.solve(A));
    }
}
