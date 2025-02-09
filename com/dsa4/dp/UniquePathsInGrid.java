package com.dsa4.dp;

/**
 * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
 * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
 * <p>
 * Now consider if some obstacles are added to the grids.
 * Return the total number unique paths from (1, 1) to (n, m).
 * <p>
 * Note:
 * 1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
 * 2. Given Source Point and Destination points are 1-based index.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= n, m <= 100
 * A[i][j] = 0 or 1
 * <p>
 * <p>
 * Input Format
 * <p>
 * Firts and only argument A is a 2D array of size n * m.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the number of unique paths from (1, 1) to (n, m).
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [
 * [0, 0, 0]
 * [0, 1, 0]
 * [0, 0, 0]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [0, 0, 0]
 * [1, 1, 1]
 * [0, 0, 0]
 * ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
 * So, the total number of unique paths is 2.
 * Explanation 2:
 * <p>
 * It is not possible to reach (n, m) from (1, 1). So, ans is 0.
 */
public class UniquePathsInGrid {

    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];

        // Initialize the first cell
        dp[0][0] = (A[0][0] == 0) ? 1 : 0;

        // Fill the first row
        for (int j = 1; j < m; j++) {
            dp[0][j] = (A[0][j] == 0) ? dp[0][j - 1] : 0;
        }

        // Fill the first column
        for (int i = 1; i < n; i++) {
            dp[i][0] = (A[i][0] == 0) ? dp[i - 1][0] : 0;
        }

        for (int i = 1; i<n; i++) {
            for(int j = 1; j<m; j++) {

                if(A[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {

        int[][] A = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsInGrid uq = new UniquePathsInGrid();
        System.out.println("Result->" + uq.uniquePathsWithObstacles(A));
    }
}
