package com.dsa4.graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * You are the Prime Minister of a country and once you went for a world tour.
 * After 5 years, when you returned to your country, you were shocked to see the condition of the roads between the cities. So, you plan to repair them, but you cannot afford to spend a lot of money.
 * <p>
 * The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.
 * <p>
 * The cost of repairing a road between (i, j) and (i + 1, j) is A[i]. The cost of repairing a road between (i, j) and (i, j + 1) is B[j].
 * <p>
 * Return the minimum cost of repairing the roads such that all cities can be visited from city indexed (0, 0).
 * <p>
 * As the cost can be large, return the cost modulo 109+7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N, M <= 105
 * <p>
 * 1 <= A[i], B[i] <= 103
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument will be an integer array, A, of size N.
 * The second argument will be an integer array, B, of size M.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer representing the minimum possible cost.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 1, 1]
 * B = [1, 1, 2]
 * Input 2:
 * <p>
 * A = [1, 2, 3]
 * B = [4, 5, 6]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 16
 * Output 2:
 * <p>
 * 39
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The minimum cost will be 16 if we repair the roads in the following way:
 * Repair the roads from the all cities in row 0 to row 1 i.e. (0, j) to (1, j) (0 <= j <= 3), so that the cost will be 4 (A[0] * 4).
 * Repair the roads from the all cities in row 1 to row 2 i.e. (1, j) to (2, j) (0 <= j <= 3), so that the cost will be 4 (A[1] * 4).
 * Repair the roads from the all cities in row 2 to row 3 i.e. (2, j) to (3, j) (0 <= j <= 3), so that the cost will be 4 (A[2] * 4).
 * Repair the roads (0, 0) to (0, 1), (0, 1) to (0, 2), (0, 2) to (0, 3), so that the cost will be B[0] + B[1] + B[2] = 4.
 * Total cost will be 16.
 * <p>
 * Explanation 2:
 * <p>
 * The minimum possible cost will be 39.
 */
public class DamagedRoads {

    private int MOD = 1000000007;

    class Pair implements Comparable<Pair> {
        int weight;
        int direction;

        Pair(int weight, int direction) {
            this.weight = weight;
            this.direction = direction;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public int solve(int[] A, int[] B) {

        int n = A.length;
        int m = B.length;

        ArrayList<Pair> edgeList = new ArrayList<>();
        for (int vertical : A) {
            edgeList.add(new Pair(vertical, 1));
        }
        for (int horizontal : B) {
            edgeList.add(new Pair(horizontal, 0));
        }
        Collections.sort(edgeList);

        int sum = 0;
        m++;
        n++;

        for (Pair edge : edgeList) {

            if (edge.direction == 0 && (m>=0 && n>=0)) {
                sum = sum % MOD + (n * (edge.weight)) % MOD;
                m--;
            } else if (edge.direction == 1 && (m>=0 && n>=0)) {
                sum = sum % MOD + (m * (edge.weight)) % MOD;
                n--;
            }
        }

        return sum % MOD;
    }

    public static void main(String[] args) {

        DamagedRoads dmg = new DamagedRoads();
        int[] A = {2};
        int[] B = {2, 4};
        System.out.println("Total Cost -> " + dmg.solve(A, B));
    }


}
