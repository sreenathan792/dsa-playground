package com.test.hashing;

import java.util.HashMap;

/**
 * Given an array of integers A and an integer B.
 * Find the total number of subarrays having sum equals to B.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 50000
 * -1000 <= A[i] <= 1000
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * <p>
 * <p>
 * Output Format
 * Return the total number of subarrays having sum equals to B.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 0, 1]
 * B = 1
 * Input 2:
 * A = [0, 0, 0]
 * B = 0
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
 * Explanation 1:
 * All the possible subarrays having sum 0.
 */
public class SubArraySumKCount {

    public int solve(int[] A, int B) {
        int n = A.length;
        int ans = 0;
        int[] prefArray = new int[n];
        prefArray[0] = A[0];
        for(int i = 1; i<n; i++) {
            prefArray[i] = prefArray[i-1] + A[i];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if(prefArray[i] == B)
                ans++;

            if (hm.containsKey(prefArray[i] - B)) {
                ans += hm.get(prefArray[i] - B);
            }

            if (hm.containsKey(prefArray[i])) {
                hm.put(prefArray[i], hm.get(prefArray[i]) + 1);
            } else {
                hm.put(prefArray[i], 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SubArraySumKCount saK = new SubArraySumKCount();
        int[] A = {1, 0, 1};
        int B = 1;
        System.out.println("Result -> " + saK.solve(A, B));
    }
}
