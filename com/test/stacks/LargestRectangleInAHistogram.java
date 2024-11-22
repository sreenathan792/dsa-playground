package com.test.stacks;

import java.util.Stack;

/**
 * Given an array of integers A.
 * <p>
 * <p>
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 * <p>
 * Find the area of the largest rectangle formed by the histogram.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * 1 <= A[i] <= 10000
 * <p>
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
 * Return the area of the largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 * <p>
 * A = [2]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * <p>
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * <p>
 * Explanation 2:
 * <p>
 * <p>
 * Largest rectangle has area 2.
 */
public class LargestRectangleInAHistogram {

    public int largestRectangleArea(int[] A) {

        int ans = 0;
        int n = A.length;
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

        for (int i = 0; i<n; i++) {
            int j = smallestInLeft[i];
            int k = smallestInRight[i];

            ans = Math.max(ans, A[i] * (k-j-1));
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] A = {2, 1, 5, 6, 2, 3};
        LargestRectangleInAHistogram lar = new LargestRectangleInAHistogram();

        System.out.println("Largest Rectangle Area->" + lar.largestRectangleArea(A));
    }
}
