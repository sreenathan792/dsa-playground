package com.test.stacks;

import java.util.Stack;

/**
 * Given an array of integers A.
 * <p>
 * <p>
 * The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
 * <p>
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * 1 <= A[i] <= 1000000
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the sum of values of all possible subarrays of A modulo 109+7.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * A = [1]
 * <p>
 * Input 2:
 * <p>
 * <p>
 * A = [4, 7, 3, 8]
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 26
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Only 1 subarray exists. Its value is 0.
 * Explanation 2:
 * <p>
 * value ( [4] ) = 4 - 4 = 0
 * value ( [7] ) = 7 - 7 = 0
 * value ( [3] ) = 3 - 3 = 0
 * value ( [8] ) = 8 - 8 = 0
 * value ( [4, 7] ) = 7 - 4 = 3
 * value ( [7, 3] ) = 7 - 3 = 4
 * value ( [3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3] ) = 7 - 3 = 4
 * value ( [7, 3, 8] ) = 8 - 3 = 5
 * value ( [4, 7, 3, 8] ) = 8 - 3 = 5
 * sum of values % 10^9+7 = 26
 */
public class MaxAndMin {

    int MOD = 1000000007;
    public int solve(int[] A) {
        long ans = 0;
        int n = A.length;

        int[] greatestInLeft = new int[n];
        int[] greatestInRight = new int[n];
        int[] smallestInLeft = new int[n];
        int[] smallestInRight = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            if (st.isEmpty())
                smallestInLeft[i] = -1;
            else
                smallestInLeft[i] = st.peek();

            st.push(i);
        }

        st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                st.pop();
            }

            if (st.isEmpty())
                greatestInLeft[i] = -1;
            else
                greatestInLeft[i] = st.peek();

            st.push(i);
        }

        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            if (st.isEmpty())
                smallestInRight[i] = n;
            else
                smallestInRight[i] = st.peek();

            st.push(i);
        }

        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                st.pop();
            }

            if (st.isEmpty())
                greatestInRight[i] = n;
            else
                greatestInRight[i] = st.peek();

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long subArraysMax = (long) (i - greatestInLeft[i]) * (greatestInRight[i] - i);
            long subArraysMin = (long) (i - smallestInLeft[i]) * (smallestInRight[i] - i);

            long diff = (subArraysMax - subArraysMin) % MOD;
            ans = (ans + (A[i] * diff) % MOD) % MOD;
        }

        if(ans<0)
            ans = ans+MOD;

        return (int) ans;
    }

    public static void main(String[] args) {

        int[] A = {4, 7, 3, 8};
        MaxAndMin maxAndMin = new MaxAndMin();

        System.out.println("Result->" + maxAndMin.solve(A));
    }
}
