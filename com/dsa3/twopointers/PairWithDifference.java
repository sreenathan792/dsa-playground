package com.dsa3.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an one-dimensional integer array A of size N and an integer B.
 * <p>
 * Count all distinct pairs with difference equal to B.
 * <p>
 * Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 104
 * <p>
 * 0 <= A[i], B <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an one-dimensional integer array A of size N.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the count of all distinct pairs with difference equal to B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 5, 3, 4, 2]
 * B = 3
 * <p>
 * Input 2:
 * <p>
 * A = [8, 12, 16, 4, 0, 20]
 * B = 4
 * <p>
 * Input 3:
 * <p>
 * A = [1, 1, 1, 2, 2]
 * B = 0
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * <p>
 * Output 2:
 * <p>
 * 5
 * <p>
 * Output 3:
 * <p>
 * 2
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
 * <p>
 * Explanation 2:
 * <p>
 * There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
 * <p>
 * Explanation 3:
 * <p>
 * There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
public class PairWithDifference {

    public int solve(int[] A, int B) {

        int n = A.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if(freq.containsKey(A[i])) {
                int frequency = freq.get(A[i]);
                freq.put(A[i], frequency + 1);
            } else {
                freq.put(A[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            int num = A[i] + B;
            int temp = freq.getOrDefault(num, 0);

            if ((B == 0 && temp > 1) || (B != 0 && temp > 0)) {
                cnt++;
                freq.put(num, 0);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        PairWithDifference ps = new PairWithDifference();
        int[] A = {1, 1, 1, 2, 2};
        System.out.println("Count of Pairs = " + ps.solve(A, 0));
    }

}
