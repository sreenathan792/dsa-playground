package com.dsa4.dp;

import java.util.Scanner;

/**
 * Given a positive integer A, write a program to find the Ath Fibonacci number.
 * <p>
 * In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
 * <p>
 * NOTE: 0th term is 0. 1th term is 1 and so on.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= A <= 44
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
 * Return an integer denoting the Ath Fibonacci number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 4
 * Input 2:
 * <p>
 * A = 6
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 8
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 * 0th term is 0 So, 4th term of Fibonacci series is 3.
 * Explanation 2:
 * <p>
 * 6th term of Fibonacci series is 8.
 */
public class Fibonacci {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scn = new Scanner(System.in);
        int A = 4;
        int[] fibArr = new int[A + 1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for (int i = 2; i < A; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }

        System.out.print(fibArr[A]);
    }
}
