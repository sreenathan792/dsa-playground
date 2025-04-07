package com.dsa4.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N, M <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * A[i][j] = 'X' or 'O'
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The First and only argument is character matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a single integer denoting number of black shapes.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [ [X, X, X], [X, X, X], [X, X, X] ]
 * Input 2:
 * <p>
 * A = [ [X, O], [O, X] ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All X's belong to single shapes
 * Explanation 2:
 * <p>
 * Both X's belong to different shapes
 */
public class BlackShapes {

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {

        BlackShapes blackShapes = new BlackShapes();
        String[] A = {"XXX", "XXX", "XXX"};
                //{"X,X,O,X", "O,X,O,X", "X,O,O,X", "O,X,O,X"};
        System.out.println("Total Black Shapes -> " + blackShapes.black(A));
    }

    public int black(String[] A) {

        int n = A.length;
        int m = A[0].split("").length;

        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] word = A[i].split("");
            for (int j = 0; j < m; j++) {
                if ("X".equals(word[j])) {
                    mat[i][j] = 'X';
                } else {
                    mat[i][j] = 'O';
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int count = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(mat[i][j] == 'X') {
                    count++;
                    bfsTraversal(i, j, mat, directions);
                }
            }
        }

        return count;
    }

    public void bfsTraversal (int i, int j, char[][] mat, int[][] directions) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i,j));
        if(mat[i][j] == 'X') {
            mat[i][j] = 'O';
        }

        int n = mat.length;
        int m = mat[0].length;

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int ver = p.i;
            int hor = p.j;

            for (int[] direction : directions) {
                int newRow = ver + direction[0];
                int newCol = hor + direction[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] == 'X') {
                    queue.add(new Pair(newRow, newCol));
                    mat[newRow][newCol] = 'O'; // mark visited
                }
            }
        }
    }
}
