package com.test.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of integers A of size N x M in which each row is sorted.
 * <p>
 * <p>
 * Find and return the overall median of matrix A.
 * <p>
 * NOTE: No extra memory is allowed.
 * <p>
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N, M <= 10^5
 * <p>
 * 1 <= N*M <= 10^6
 * <p>
 * 1 <= A[i] <= 10^9
 * <p>
 * N*M is odd
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and only argument given is the integer matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the overall median of matrix A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [   [1, 3, 5],
 * [2, 6, 9],
 * [3, 6, 9]   ]
 * Input 2:
 * <p>
 * A = [   [5, 17, 100]    ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * 17
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * Explanation 2:
 * <p>
 * Median is 17.
 */

public class MatrixMedian {

    public int findMedian(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int countRequired = (n*m)/2 + 1;
        int ans = -1;

        int lower = 0;
        int higher = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            higher = Math.max(higher, A[i][m-1]);
        }

        while(lower<=higher) {

            int mid = lower + (higher-lower)/2;
            int count = 0;

            for(int[] row : A) {
                int p = count(row,mid);
                count += p;
            }

            if(count>=countRequired) {
                ans = mid;
                higher = mid-1;
            } else {
                lower = mid+1;
            }
        }

        return ans;
    }

    private int count(int[] row, int mid) {

        int i = 0;
        int j = row.length-1;

        int count = -1;
        while(i<=j) {
            int m = i+(j-i)/2;
            if(row[m]>mid) {
                count = m;
                j = m-1;
            } else {
                i = m+1;
            }
        }

        if(count == -1)
            return row.length;

        return count;
    }

    public static void main(String[] args) {

        int[][] mat = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};

        MatrixMedian matMed = new MatrixMedian();
        System.out.println("Median of the matrix -> " + matMed.findMedian(mat));
    }
}
