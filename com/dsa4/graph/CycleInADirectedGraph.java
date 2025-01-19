package com.dsa4.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * <p>
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 * <p>
 * NOTE:
 * <p>
 * The cycle must contain atleast two nodes.
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 2 <= A <= 105
 * <p>
 * 1 <= M <= min(200000,A*(A-1))
 * <p>
 * 1 <= B[i][0], B[i][1] <= A
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is an integer A representing the number of nodes in the graph.
 * <p>
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if cycle is present else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 5
 * B = [  [1, 2]
 * [4, 1]
 * [2, 4]
 * [3, 4]
 * [5, 2]
 * [1, 3] ]
 * Input 2:
 * <p>
 * A = 5
 * B = [  [1, 2]
 * [2, 3]
 * [3, 4]
 * [4, 5] ]
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
 * The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
 * Explanation 2:
 * <p>
 * The given graph doesn't contain any cycle.
 */
public class CycleInADirectedGraph {

    public int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=A; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : B) {
            ArrayList<Integer> next = adj.get(edge[0]);
            next.add(edge[1]);
        }

        System.out.println("Adjacency List = "+ adj.toString());

        boolean[] visit = new boolean[A+1];
        boolean[] path = new boolean[A+1];

        for(int i = 0; i<=A; i++) {
            if(!visit[i]) {
                if(dfs(i, adj, visit, path)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visit, boolean[] path) {

        visit[i] = true;
        path[i] = true;

        for(int v : adj.get(i)) {

            if(path[v])
                return true;

            if(!visit[v]) {
                if(dfs(v, adj, visit, path)) {
                    return true;
                }
            }

        }

        path[i] = false;

        return false;

    }

    public static void main(String[] args) {

        CycleInADirectedGraph cyc = new CycleInADirectedGraph();
        int A = 5;
        int[][] B = {{1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}};

        /*int[][] B = {{1, 2},
                {2, 3},
                {3, 4},
                {4, 5}};*/
        System.out.println("Cycle Exists->" + cyc.solve(A, B));
    }
}
