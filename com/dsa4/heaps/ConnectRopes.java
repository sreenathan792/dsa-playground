package com.dsa4.heaps;

import java.util.PriorityQueue;

/**
 * You are given an array A of integers that represent the lengths of ropes.
 * <p>
 * <p>
 * <p>
 * <p>
 * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
 * <p>
 * Find and return the minimum cost to connect these ropes into one rope.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the minimum cost to connect these ropes into one rope.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 33
 * Output 2:
 * <p>
 * 182
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Given array A = [1, 2, 3, 4, 5].
 * Connect the ropes in the following manner:
 * 1 + 2 = 3
 * 3 + 3 = 6
 * 4 + 5 = 9
 * 6 + 9 = 15
 * <p>
 * So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
 * Explanation 2:
 * <p>
 * Given array A = [5, 17, 100, 11].
 * Connect the ropes in the following manner:
 * 5 + 11 = 16
 * 16 + 17 = 33
 * 33 + 100 = 133
 * <p>
 * So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
 */
public class ConnectRopes {

    public int solve(int[] A) {

        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<n; i++) {
            pq.add(A[i]);
        }

        int count = 0;
        while(pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();
            count += first+second;
            pq.add(first+second);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        ConnectRopes connect = new ConnectRopes();
        System.out.println("Total Cost to connect ropes -> " + connect.solve(A));
    }

}
