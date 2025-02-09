package com.dsa4.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * <p>
 * Each cell can have three values:
 * <p>
 * The value 0 representing an empty cell.
 * <p>
 * The value 1 representing a fresh orange.
 * <p>
 * The value 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 * <p>
 * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N, M <= 1000
 * <p>
 * 0 <= A[i][j] <= 2
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * <p>
 * If this is impossible, return -1 instead.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * A = [   [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1]   ]
 * <p>
 * <p>
 * Input 2:
 * <p>
 * <p>
 * <p>
 * A = [   [2, 1, 1]
 * [0, 1, 1]
 * [1, 0, 1]   ]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Minute 0: [ [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1] ]
 * Minute 1: [ [2, 2, 1]
 * [2, 1, 0]
 * [0, 1, 1] ]
 * Minute 2: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 1, 1] ]
 * Minute 3: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 2, 1] ]
 * Minute 4: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 2, 2] ]
 * At Minute 4, all the oranges are rotten.
 * Explanation 2:
 * <p>
 * The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
 */
public class RottenOranges {

    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                } else if (A[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int[] row = {-1, 0, 1, 0};
        int[] column = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            int time = cell[2];

            for (int k = 0; k < 4; k++) {
                int x = i + row[k];
                int y = j + column[k];

                if (x >= 0 && y >= 0 && x < n && y < m) {

                    if (A[x][y] == 1) {
                        A[x][y] = 2;
                        queue.offer(new int[]{x, y, time + 1});
                        fresh--;
                        if (fresh == 0)
                            return time + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        RottenOranges ro = new RottenOranges();
        int[][] A = {{0, 2, 1}, {2, 2, 1}, {0, 1, 0}, {2, 1, 1}, {0, 1, 1}, {1, 2, 1}};
        System.out.println("Time Taken to rot->" + ro.solve(A));
    }
}
