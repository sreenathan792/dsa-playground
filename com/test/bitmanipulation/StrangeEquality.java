package com.test.bitmanipulation;

/**
 * Given an integer A.
 * Two numbers, X and Y, are defined as follows:
 * <p>
 * X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
 * Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
 * Find and return the XOR of X and Y.
 * <p>
 * NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
 * <p>
 * NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the XOR of X and Y.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * A = 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * 10
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
 */
public class StrangeEquality {

    public int solve(int A) {

        int countOfBits = countBits(A);
        int mask = (1 << Integer.SIZE - Integer.numberOfLeadingZeros(A)) - 1;

        int x = ~A & mask;
        int y = 1<<countOfBits;

        return x^y;
    }

    private int countBits(int A) {

        int count = 0;
        while(A>0) {
            count++;
            A = A>>1;
        }

        return count;
    }

    public static void main(String[] args) {

        StrangeEquality seq = new StrangeEquality();
        System.out.println("Strange Equality ->" + seq.solve(5));
    }

}
