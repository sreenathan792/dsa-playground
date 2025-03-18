package com.test.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * <h4>54. Spiral Matrix</h4>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int rowBegin = 0;
        int columnBegin = 0;
        int rowEnd = m-1;
        int columnEnd = n-1;

        while(rowBegin<=rowEnd && columnBegin<=columnEnd) {

            //Right Traversal
            for(int j = columnBegin; j<=columnEnd; j++) {
                list.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //Down Traversal
            for(int i = rowBegin; i<=rowEnd; i++) {
                list.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            //Left Traversal
            if(rowBegin<=rowEnd) { //Stopping Condition
                for(int j = columnEnd; j>=columnBegin; j--) {
                    list.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            //Up Traversal
            if(columnBegin<=columnEnd) { //Stopping Condition
                for(int i = rowEnd; i>=rowBegin; i--) {
                    list.add(matrix[i][columnBegin]);
                }
                columnBegin++;
            }
        }

        return list;
    }

    public static void main(String[] args) {

        SpiralMatrix sm = new SpiralMatrix();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Spiral Order -> " + sm.spiralOrder(mat));
    }
}
