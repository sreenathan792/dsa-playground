package com.dsa4.graph;

import java.util.ArrayList;

/**
 * Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
 * <p>
 * B[i][0] to node B[i][1].
 * <p>
 * Find whether a path exists from node 1 to node A.
 * <p>
 * Return 1 if path exists else return 0.
 * <p>
 * NOTE:
 * <p>
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
 * Return 1 if path exists between node 1 to node A else return 0.
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
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The given doens't contain any path from node 1 to node 5 so we will return 0.
 * Explanation 2:
 * <p>
 * Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
 */
public class PathInADirectedGraph {

    public int solve(int A, int[][] B) {

        int n = B.length;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i<=A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++) {
            ArrayList<Integer> currEdge = adjacencyList.get(B[i][0]);
            currEdge.add(B[i][1]);
        }

        System.out.println(adjacencyList.toString());

        boolean[] visit = new boolean[A+1];
        if(dfs(adjacencyList, 1, A, visit)){
            return 1;
        }

        return 0;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adjacencyList, int src, int dest, boolean[] visit) {

        if (src == dest) {
            return true;
        }

        visit[src] = true;

        for (int neighbor : adjacencyList.get(src)) {
            if (!visit[neighbor] && dfs(adjacencyList, neighbor, dest, visit)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        PathInADirectedGraph gr = new PathInADirectedGraph();
        int A = 5;
        int[][] Bc = {{1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}};

        int[][] B = {{1, 2},
                {2, 3},
                {3, 4},
                {4, 5}};
        System.out.println("Path Exists->" + gr.solve(A, B));
    }
}
