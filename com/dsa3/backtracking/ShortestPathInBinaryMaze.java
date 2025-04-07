package com.dsa3.backtracking;

public class ShortestPathInBinaryMaze {

    int ans = Integer.MAX_VALUE;

    public int FindShortestPath(int[][] A, int B, int C, int D, int E) {

        int n = A.length;
        int m = A[0].length;
        boolean[][] visit = new boolean[n][m];

        explorePaths(A, visit, B, C, D, E, 0);
        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }

    private void explorePaths(int[][] A, boolean[][] visit, int B, int C, int D, int E, int pathLength) {

        if (B == D && C == E) {
            ans = Math.min(ans, pathLength);
            return;
        }

        int n = A.length;
        int m = A[0].length;

        int[] row = {-1, 1, 0, 0};
        int[] column = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {

            int newI = B + row[k];
            int newJ = C + column[k];

            if (newI < n && newJ < m && newI >= 0 && newJ >= 0 && A[newI][newJ] == 1 && !visit[newI][newJ]) {
                visit[newI][newJ] = true;
                explorePaths(A, visit, newI, newJ, D, E, pathLength + 1);
                visit[newI][newJ] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        ShortestPathInBinaryMaze paths = new ShortestPathInBinaryMaze();
        System.out.println("Shortest Path Length -> " + paths.FindShortestPath(A, 0, 0, 3, 3));
    }
}
