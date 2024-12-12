package com.dsa3.combinatorics;

import java.util.Arrays;

/**
 * Write a program to print the pascal triangle up to A rows.
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 25
 * <p>
 * Input Format
 * <p>
 * The first argument is an integer A.
 * <p>
 * Output Format
 * <p>
 * <p>
 * Return a 2D array consisting of A rows whose each row contains A integers.
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * <p>
 * A = 5
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1 0 0
 * 1 1 0
 * 1 2 1
 * Output 2:
 * <p>
 * 1 0 0 0 0
 * 1 1 0 0 0
 * 1 2 1 0 0
 * 1 3 3 1 0
 * 1 4 6 4 1
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Row 1 = 1 0 0
 * Row 2 = 1C0 1C1 0 = 1 1 0
 * Row 3 = 2C0 2C1 2C2 = 1 2 1
 */
public class PascalsTriangle {

    public int[][] solve(int A) {

        int res[][] = new int [A][A];
        for(int i = 0; i<A; i++) {

            res[i][0] = 1;
            res[i][i] = 1;

            for(int j = 1; j<i; j++) {

                res[i][j] = res[i-1][j-1] + res[i-1][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle pascal = new PascalsTriangle();
        System.out.println("Closest = " + Arrays.deepToString(pascal.solve(5)));
    }
}
