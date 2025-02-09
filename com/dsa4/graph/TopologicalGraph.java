package com.dsa4.graph;

import java.util.*;

/**
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * <p>
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * <p>
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 * <p>
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 * <p>
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
 * <p>
 * NOTE:
 * <p>
 * There are no self-loops in the graph.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 2 <= A <= 104
 * <p>
 * 1 <= M <= min(100000,A*(A-1))
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
 * Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 6
 * B = [  [6, 3]
 * [6, 1]
 * [5, 1]
 * [5, 2]
 * [3, 4]
 * [4, 2] ]
 * Input 2:
 * <p>
 * A = 3
 * B = [  [1, 2]
 * [2, 3]
 * [3, 1] ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [5, 6, 1, 3, 4, 2]
 * Output 2:
 * <p>
 * []
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
 * Explanation 2:
 * <p>
 * The given graph contain cycle so topological ordering not possible we will return empty array.
 */
public class TopologicalGraph {

    public int[] solve(int A, int[][] B) {

        ArrayList<Integer> topoGraph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[A + 1];
        for (int[] edge : B) {

            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            topoGraph.add(x);

            for (int v : graph.get(x)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return topoGraph.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        TopologicalGraph top = new TopologicalGraph();
        int[][] B = {{1, 4}, {1, 2}, {4, 2}, {4, 3}, {3, 2}, {5, 2}, {3, 5}, {8, 2}, {8, 6}};
        System.out.println("Topological Graph -> " + Arrays.toString(top.solve(8, B)));
    }
}
