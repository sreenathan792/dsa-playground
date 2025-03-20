package com.dsa4.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 * <p>
 * You have to find an integer array D of size A such that:
 * <p>
 * D[i]: Shortest distance from the C node to node i.
 * If node i is not reachable from C then -1.
 * Note:
 * <p>
 * There are no self-loops in the graph.
 * There are no multiple edges between two pairs of vertices.
 * The graph may or may not be connected.
 * Nodes are numbered from 0 to A-1.
 * Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 1e5
 * <p>
 * 0 <= B[i][0],B[i][1] < A
 * <p>
 * 0 <= B[i][2] <= 1e3
 * <p>
 * 0 <= C < A
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument is an integer A, representing the number of nodes in the graph.
 * The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
 * The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the integer array D.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 6
 * B = [   [0, 4, 9]
 * [3, 4, 6]
 * [1, 2, 1]
 * [2, 5, 1]
 * [2, 4, 5]
 * [0, 3, 7]
 * [0, 1, 1]
 * [4, 5, 7]
 * [0, 5, 1] ]
 * C = 4
 * Input 2:
 * <p>
 * A = 5
 * B = [   [0, 3, 4]
 * [2, 3, 3]
 * [0, 1, 9]
 * [3, 4, 10]
 * [1, 3, 8]  ]
 * C = 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * D = [7, 6, 5, 6, 0, 6]
 * Output 2:
 * <p>
 * D = [14, 18, 13, 10, 0]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All Paths can be considered from the node C to get shortest path
 * Explanation 2:
 * <p>
 * All Paths can be considered from the node C to get shortest path
 */
public class Dijkstra {

    class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight-o.weight;
        }
    }

    public int[] solve(int A, int[][] B, int C) {

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adjList.add(new ArrayList<>());
        }

        int n = B.length;
        for (int i = 0; i < n; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int wt = B[i][2];

            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, wt));
        }

        int[] distArray = new int[A];
        Arrays.fill(distArray, Integer.MAX_VALUE);
        distArray[C] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for(Pair src : adjList.get(C)) {
            minHeap.offer(new Pair(src.node, src.weight));
        }

        while (!minHeap.isEmpty()) {
            Pair dest = minHeap.poll();
            int d = dest.weight;
            int v = dest.node;

            if (distArray[v] < d) {
                continue;
            }

            distArray[v] = d;

            for (Pair conn : adjList.get(v)) {
                int newDis = distArray[v] + conn.weight;
                if (newDis < distArray[conn.node]) {
                    minHeap.offer(new Pair(conn.node, newDis));
                }
            }
        }

        for (int k = 0; k < A; k++) {
            if (distArray[k] == Integer.MAX_VALUE)
                distArray[k] = -1;
        }

        return distArray;
    }

    public static void main(String[] args) {

        Dijkstra di = new Dijkstra();
        int[][] B = {{0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}};
        System.out.println("Array of shortest distance -> " + Arrays.toString(di.solve(6, B, 4)));
    }
}
