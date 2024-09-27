package com.test.hashing;

import java.util.Arrays;
import java.util.HashMap;

/**
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * <p>
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * <p>
 * NOTE: if B > N, return an empty array.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * <p>
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 1, 3, 4, 3]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 1, 2, 2]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 3, 3, 2]
 * Output 2:
 * <p>
 * [1, 1, 1, 1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * A=[1, 2, 1, 3, 4, 3] and B = 3
 * All windows of size B are
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 * So, we return an array [2, 3, 3, 2].
 * Explanation 2:
 * <p>
 * Window size is 1, so the output array is [1, 1, 1, 1].
 */
public class DistinctNumbersInWindow {

    public int[] dNums(int[] A, int B) {
        int n = A.length;
        if(B>n){
            return new int[0];
        }
        int[] res = new int[n-B+1];
        HashMap<Integer, Integer> distCountMap = new HashMap<>();
        for (int i = 0; i<B; i++) {
            if(distCountMap.containsKey(A[i])) {
                distCountMap.put(A[i], distCountMap.get(A[i])+1);
            } else {
                distCountMap.put(A[i], 1);
            }
        }
        res[0] = distCountMap.size();

        int i = 1, j = B;
        while(j<n) {

            if(distCountMap.containsKey(A[i-1])){
                distCountMap.put(A[i-1], distCountMap.get(A[i-1]) - 1);
                if(distCountMap.get(A[i-1]) == 0) {
                    distCountMap.remove(A[i-1]);
                }
            }

            if(distCountMap.containsKey(A[j])){
                distCountMap.put(A[j], distCountMap.get(A[j]) + 1);
            } else {
                distCountMap.put(A[j], 1);
            }

            res[i] = distCountMap.size();

            i++;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        DistinctNumbersInWindow dnIW = new DistinctNumbersInWindow();
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        System.out.println("Result -> " + Arrays.toString(dnIW.dNums(A, B)));
    }
}
