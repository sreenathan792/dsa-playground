package com.dsa4.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of A courses you have to take, labeled from 1 to A.
 * <p>
 * Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 * <p>
 * So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 6*104
 * <p>
 * 1 <= length(B) = length(C) <= 105
 * <p>
 * 1 <= B[i], C[i] <= A
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument of input contains an integer A, representing the number of courses.
 * <p>
 * The second argument of input contains an integer array, B.
 * <p>
 * The third argument of input contains an integer array, C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * B = [1, 2]
 * C = [2, 3]
 * Input 2:
 * <p>
 * A = 2
 * B = [1, 2]
 * C = [2, 1]
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
 * It is possible to complete the courses in the following order:
 * 1 -> 2 -> 3
 * Explanation 2:
 * <p>
 * It is not possible to complete all the courses.
 */
public class PossibilityOfFinishing {

    public int solve(int A, int[] B, int[] C) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        int n = B.length;
        for(int i = 0; i<n; i++) {
            adj.get(B[i]).add(C[i]);
        }

        boolean[] visit = new boolean[A+1];
        boolean[] path = new boolean[A+1];

        for(int i = 1; i<=A; i++) {

            if(!visit[i]) {

                if(dfs(i, visit, path, adj)) {
                    return 0;
                }
            }
        }

        return 1;
    }

    public boolean dfs(int i, boolean[] visit, boolean[] path, List<List<Integer>> adj) {

        visit[i] = true;
        path[i] = true;

        for(int v : adj.get(i)) {

            if(path[v])
                return true;

            if(!visit[v]) {
                if(dfs(v, visit, path, adj)) {
                    return true;
                }
            }

        }

        path[i] = false;

        return false;
    }

    public static void main(String[] args) {

        PossibilityOfFinishing poss = new PossibilityOfFinishing();
        int A = 3;
        int[] B = {1, 2, 3};
        int[] C = {2, 3, 1};

        System.out.println("Possibility of Finishing ->" + poss.solve(A, B, C));
    }
}
