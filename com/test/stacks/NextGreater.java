package com.test.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array A, find the next greater element G[i] for every element A[i] in the array.
 * The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
 * <p>
 * More formally:
 * <p>
 * G[i] for an element A[i] = an element A[j] such that
 * j is minimum possible AND
 * j > i AND
 * A[j] > A[i]
 * <p>
 * Elements for which no greater element exists, consider the next greater element as -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 105
 * <p>
 * 1 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and the only argument of input contains the integer array, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer array representing the next greater element for each index in A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [4, 5, 2, 10]
 * <p>
 * Input 2:
 * <p>
 * A = [3, 2, 1]
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [5, 10, 10, -1]
 * <p>
 * Output 2:
 * <p>
 * [-1, -1, -1]
 */
public class NextGreater {

    public int[] nextGreater(int[] A) {

        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) {
                st.pop();
            }

            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();

            st.push(i);
        }

        for (int idx = 0; idx < n; idx++) {
            if (res[idx] > -1) {
                res[idx] = A[res[idx]];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] A = {4, 5, 2, 10};
        NextGreater ng = new NextGreater();

        System.out.println("Result->" + Arrays.toString(ng.nextGreater(A)));
    }
}


