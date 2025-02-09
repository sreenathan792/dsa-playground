package com.dsa4.graph;

import java.util.*;

/**
 * Given a weighted undirected graph having A nodes, a source node C and destination node D.
 * <p>
 * Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
 * <p>
 * You are expected to do it in Time Complexity of O(A + M).
 * <p>
 * Note:
 * <p>
 * There are no self-loops in the graph.
 * <p>
 * No multiple edges between two pair of vertices.
 * <p>
 * The graph may or may not be connected.
 * <p>
 * Nodes are Numbered from 0 to A-1.
 * <p>
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 105
 * <p>
 * 0 <= B[i][0], B[i][1] < A
 * <p>
 * 1 <= B[i][2] <= 2
 * <p>
 * 0 <= C < A
 * <p>
 * 0 <= D < A
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is an integer A, representing the number of nodes.
 * <p>
 * The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
 * <p>
 * The third argument given is an integer C, representing the source node.
 * <p>
 * The fourth argument is an integer D, representing the destination node.
 * <p>
 * Note: B[i][2] will be either 1 or 2.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * A = 6
 * B = [   [2, 5, 1]
 * [1, 3, 1]
 * [0, 5, 2]
 * [0, 2, 2]
 * [1, 4, 1]
 * [0, 1, 1] ]
 * C = 3
 * D = 2
 * Input 2:
 * <p>
 * A = 2
 * B = [   [0, 1, 1]
 * ]
 * C = 0
 * D = 1
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The path to be followed will be:
 * 3 -> 1 (Edge weight : 1)
 * 1 -> 0 (Edge weight : 1)
 * 0 -> 2 (Edge weight : 2)
 * Total length of path = 1 + 1 + 2 = 4.
 * Explanation 2:
 * <p>
 * Path will be 0-> 1.
 */
public class AnotherBFS {

    static int maxn = 200009;
    static int[] vis = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
    }

    public int solve(int A, int[][] B, int C, int D) {
        graph();
        int n = A;
        for (int[] it : B) {
            int x = it[0];
            int y = it[1];
            int w = it[2];
            if (w == 1) {
                adj.get(x).add(y);
                adj.get(y).add(x);
            } else {
                adj.get(x).add(x + n);
                adj.get(x + n).add(y);
                adj.get(y).add(y + n);
                adj.get(y + n).add(x);
            }
        }
        return bfs(C, D);
    }

    public int bfs(int source, int destination) {
        vis[source] = 1;
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.offer(new Pair(source, 0));
        while (q.size() > 0) {
            Pair p = q.poll();
            int x = p.ff;
            int w = p.ss;
            if (x == destination)
                return w;
            for (int v : adj.get(x)) {
                if (vis[v] == 0) {
                    vis[v] = 1;
                    q.offer(new Pair(v, w + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        AnotherBFS bfs = new AnotherBFS();
        int[][] B = {{2, 5, 1},
                {1, 3, 1},
                {0, 5, 2},
                {0, 2, 2},
                {1, 4, 1},
                {0, 1, 1}};
        System.out.println("Path Possible -> " + bfs.solve(6, B, 3, 2));
    }
}

class Pair {
    int ff;
    int ss;
    public Pair(int a, int b) {
        this.ff = a;
        this.ss = b;
    }
}



