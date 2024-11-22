package com.test.binarySearch;

/**
 * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
 * <p>
 * This matrix A has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Return 1 if B is present in A, else return 0.
 * <p>
 * NOTE: Rows are numbered from top to bottom, and columns are from left to right.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N, M <= 1000
 * 1 <= A[i][j], B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if B is present in A else, return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [
 * [1,   3,  5,  7]
 * [10, 11, 16, 20]
 * [23, 30, 34, 50]
 * ]
 * B = 3
 * Input 2:
 * <p>
 * A = [
 * [5, 17, 100, 111]
 * [119, 120, 127, 131]
 * ]
 * B = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 3 is present in the matrix at A[0][1] position so return 1.
 * Explanation 2:
 * <p>
 * 3 is not present in the matrix so return 0.
 */
public class MatrixSearch {

    public int searchMatrix(int[][] A, int B) {

        int n = A.length;
        int m = A[0].length;
        int high = n*m-1;
        int low = 0;

        while(low<=high) {

            int mid = low + (high-low)/2;
            int row = mid/m;
            int column = mid%m;
            if(A[row][column] == B) {
                return 1;
            }

            if(B < A[row][column]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        MatrixSearch matBinSer = new MatrixSearch();
        int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println("Is element present in matrix -> " + matBinSer.searchMatrix(mat, 30));
    }
}
