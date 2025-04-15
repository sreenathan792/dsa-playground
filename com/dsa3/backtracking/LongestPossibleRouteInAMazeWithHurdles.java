package com.dsa3.backtracking;

/**
 * Given an N x M matrix, with a few hurdles arbitrarily placed, calculate the length of the longest possible route possible from source to a destination within the matrix. If there is no path exist, return -1. Hurdles are represented as 0.
 * <p>
 * We are allowed to move to only adjacent cells which are not hurdles. The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.
 * <p>
 * You are given the source A, destination B and the matrix C. Return the length of the longest possible route from source to destination
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 10
 * 1 <= M <= 10
 * 4 <= N * M <= 12
 * 0 <= A[0], B[0] < N
 * 0 <= A[1], B[1] < M
 * 0 <= C[i][j] <= 1
 * <p>
 * A and B are distinct
 * <p>
 * <p>
 * Input Format
 * First argument is the Source A, which is an integer array of size 2.
 * Second argument is the Destination B, which is an integer array of size 2.
 * Third argument is the Matrix C, which is a 2-D integer array consists of 0s and 1s.
 * <p>
 * <p>
 * Output Format
 * Return an Integer, which is the length of the longest possible route.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [0, 0]
 * B = [2, 2]
 * C = [[1, 1, 1],
 * [1, 1, 1],
 * [1, 1, 1]]
 * Input 2:
 * A = [0, 1]
 * B = [2, 0]
 * C = [[1, 1],
 * [0, 0],
 * [1, 1]]
 * Input 3:
 * A = [1, 1]
 * B = [0, 3]
 * C = [[1, 1, 0, 1],
 * [1, 1, 0, 1],
 * [1, 1, 1, 1]]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 8
 * Output 2:
 * -1
 * Output 3:
 * 9
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * The Longest possible path from source to destination is 8. One possible path is mentioned below.
 * <p>
 * Explanation 2:
 * The 1st Row(0-based), is completely blocked.  There is no way from (0, 1) to (2, 0)
 * Explanation 3:
 * The Longest possible path from source to destination is 9. One possible path is mentioned below.
 */
public class LongestPossibleRouteInAMazeWithHurdles {

    private int ans = Integer.MIN_VALUE;

    public int solve(int[] A, int[] B, int[][] C) {

        int srcI = A[0];
        int srcJ = A[1];

        int destI = B[0];
        int destJ = B[1];

        if (C[srcI][srcJ] == 0 || C[destI][destJ] == 0) {
            return -1;
        }

        boolean[][] visit = new boolean[C.length][C[0].length];
        visit[srcI][srcJ] = true;

        exploreAllPaths(srcI, srcJ, destI, destJ, C, 0, visit);

        if (ans == Integer.MIN_VALUE) {
            return -1;
        }

        return ans;
    }

    private void exploreAllPaths(int srcI, int srcJ, int destI, int destJ, int[][] c, int pathLength, boolean[][] visit) {

        int n = c.length;
        int m = c[0].length;
        if (srcI == destI && srcJ == destJ) {
            ans = Math.max(ans, pathLength);
            return;
        }

        int[] dirI = {0, 1, -1, 0};
        int[] dirJ = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {

            int newI = srcI + dirI[i];
            int newJ = srcJ + dirJ[i];

            if (newI < n && newJ < m && newI >= 0 && newJ >= 0 && !visit[newI][newJ] && c[newI][newJ] != 0) {
                visit[newI][newJ] = true;
                exploreAllPaths(newI, newJ, destI, destJ, c, pathLength + 1, visit);
                visit[newI][newJ] = false;
            }
        }
    }

    public static void main(String[] args) {

        int[] A = {0, 0};
        int[] B = {2, 2};
        int[][] C = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        LongestPossibleRouteInAMazeWithHurdles longest = new LongestPossibleRouteInAMazeWithHurdles();
        System.out.println("Longest Path -> " + longest.solve(A, B, C));
    }
}
