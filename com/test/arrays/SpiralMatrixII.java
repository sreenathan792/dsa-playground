package com.test.arrays;

import java.util.Arrays;

/**
 * <h4>59. Spiral Matrix II</h4>
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        int[][] mat = new int[n][n];
        int row = 0;
        int column = 0;
        int num = 1;

        while(n>1) {
            int i = row;
            int j = column;

            for(int k=0; k<n-1; k++) {
                mat[i][j] = num++;
                j++;
            }

            for(int k=0; k<n-1; k++) {
                mat[i][j] = num++;
                i++;
            }

            for(int k=0; k<n-1; k++) {
                mat[i][j] = num++;
                j--;
            }

            for(int k=0; k<n-1; k++) {
                mat[i][j] = num++;
                i--;
            }

            row++;
            column++;
            n -= 2;
        }

        if(n == 1) {
            mat[row][column] = num;
        }

        return mat;
    }

    public static void main(String[] args) {

        SpiralMatrixII sm = new SpiralMatrixII();
        System.out.println("Spiral Matrix -> " + Arrays.deepToString(sm.generateMatrix(3)));
    }
}
