package com.dsa4.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 * <p>
 * We need to find bridges with minimal cost such that all islands are connected.
 * <p>
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A, M <= 6*104
 * <p>
 * 1 <= B[i][0], B[i][1] <= A
 * <p>
 * 1 <= B[i][2] <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument contains an integer, A, representing the number of islands.
 * <p>
 * The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer representing the minimal cost required.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 4
 * B = [  [1, 2, 1]
 * [2, 3, 4]
 * [1, 4, 3]
 * [4, 3, 2]
 * [1, 3, 10]  ]
 * Input 2:
 * <p>
 * A = 4
 * B = [  [1, 2, 1]
 * [2, 3, 2]
 * [3, 4, 4]
 * [1, 4, 3]   ]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 6
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
 * Explanation 2:
 * <p>
 * We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
 */
public class CommutableIslands {

    class Pair implements Comparable<Pair> {
        int vertex;
        int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public int solve(int A, int[][] B) {

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
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

        boolean[] visit = new boolean[A+1];
        int sum = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.add(new Pair(1, 0));

        while(!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            int v = p.vertex;
            int wt = p.weight;
            if(visit[v]) {
                continue;
            }

            visit[v] = true;
            sum += wt;

            for(Pair x : adjList.get(v)) {

                if(!visit[x.vertex]) {
                    minHeap.add(new Pair(x.vertex, x.weight));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        CommutableIslands co = new CommutableIslands();
        int[][] B = {{1, 2, 1},
                {2, 3, 4},
                {1, 4, 3},
                {4, 3, 2},
                {1, 3, 10}};

        int[][] B1 = {{1,2,14},{2,3,7},{3,1,2}};

        System.out.println("Minimal Cost for connection ->" + co.solve(3, B1));
    }
}
