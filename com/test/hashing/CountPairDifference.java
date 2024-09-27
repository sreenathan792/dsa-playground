package com.test.hashing;

import java.util.HashMap;

/**
 * You are given an array A of N integers and an integer B.
 * Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
 * <p>
 * Since the answer can be very large, return the remainder after dividing the count with 109+7.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of integers and second argument B is an integer.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 5, 1, 2]
 * B = 4
 * Input 2:
 * <p>
 * A = [1, 2, 1, 2]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * Example 1:
 * <p>
 * The only pair is (2, 3) which gives difference as 4
 * Example 2:
 * <p>
 * The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3).
 */
public class CountPairDifference {

    public int solve(int[] A, int B) {
        long ans = 0;
        int n = A.length;
        long mod = 1000000009;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){

            if(map.containsKey(A[i]+B)) {
                ans += (map.get(A[i]+B)) % mod;
            }

            if(map.containsKey(A[i]-B)) {
                ans += (map.get(A[i]-B)) % mod;
            }

            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        return (int) (ans%mod);
    }

    public static void main(String[] args) {
        CountPairDifference co = new CountPairDifference();
        int[] A = {1, 2, 1, 2};
        int B = 1;
        System.out.println("Result -> " + co.solve(A, B));
    }
}
