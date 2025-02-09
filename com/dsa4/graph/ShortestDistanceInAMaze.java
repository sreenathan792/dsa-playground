package com.dsa4.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
 * <p>
 * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
 * <p>
 * There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
 * <p>
 * Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
 * <p>
 * Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 2 <= N, M <= 100
 * <p>
 * 0 <= A[i] <= 1
 * <p>
 * 0 <= B[i][0], C[i][0] < N
 * <p>
 * 0 <= B[i][1], C[i][1] < M
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer matrix A.
 * <p>
 * The second argument given is an array of integer B.
 * <p>
 * The third argument if an array of integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a single integer, the minimum distance required to reach destination
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * A = [ [0, 0],
 * [0, 0] ]
 * B = [0, 0]
 * C = [0, 1]
 * <p>
 * <p>
 * Input 2:
 * <p>
 * A = [ [0, 1],
 * [1, 0] ]
 * B = [0, 0]
 * C = [1, 1]
 * <p>
 * <p>
 * <p>
 * <p>
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
 * <p>
 * 1
 * <p>
 * <p>
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Go directly from start to destination in distance 1.
 * Explanation 2:
 * <p>
 * It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
 */
public class ShortestDistanceInAMaze {

    public int solve(int[][] A, int[] B, int[] C) {

        int n = A.length;
        int m = A[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] distArray = new int[n][m];
        for (int[] dis : distArray) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }

        int srcI = B[0];
        int srcJ = B[1];

        queue.offer(new int[]{srcI, srcJ, 0});

        while (!queue.isEmpty()) {

            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int d = node[2];

            if (distArray[i][j] <= d) {
                continue;
            }

            distArray[i][j] = d;

            int[] row = {-1, 0, 1, 0};
            int[] column = {0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {

                int nr = i + row[k];
                int nc = j + column[k];
                int tiles = 1;

                while (nr >= 0 && nc >= 0 && nr < n && nc < m && A[nr][nc] == 0) {
                    nr = nr + row[k];
                    nc = nc + column[k];
                    tiles++;
                }
                nr = nr - row[k];
                nc = nc - column[k];
                tiles--;
                queue.offer(new int[]{nr, nc, d + tiles});
            }

        }

        if (distArray[C[0]][C[1]] != Integer.MAX_VALUE) {
            return distArray[C[0]][C[1]];
        }

        return -1;
    }

    public static void main(String[] args) {

        ShortestDistanceInAMaze sh = new ShortestDistanceInAMaze();
        int[][] A = {{0, 0}, {0, 0}};
        int[] B = {0, 0};
        int[] C = {0, 1};
        System.out.println("Shortest Distance -> " + sh.solve(A, B, C));
    }
}
