package com.test.stacks;

import com.test.queue.ParkingIceCreamTruck;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 * <p>
 * <p>
 * More formally,
 * <p>
 * G[i] for an element A[i] = an element A[j] such that
 * <p>
 * j is maximum possible AND
 * <p>
 * j < i AND
 * <p>
 * A[j] < A[i]
 * <p>
 * Elements for which no smaller element exist, consider the next smaller element as -1.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * -109 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * A = [4, 5, 2, 10, 8]
 * <p>
 * Input 2:
 * <p>
 * <p>
 * A = [3, 2, 1]
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * <p>
 * [-1, 4, -1, 2, 2]
 * <p>
 * Output 2:
 * <p>
 * <p>
 * [-1, -1, -1]
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * <p>
 * index 1: No element less than 4 in left of 4, G[1] = -1
 * index 2: A[1] is only element less than A[2], G[2] = A[1]
 * index 3: No element less than 2 in left of 2, G[3] = -1
 * index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
 * index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
 * <p>
 * Explanation 2:
 * <p>
 * <p>
 * index 1: No element less than 3 in left of 3, G[1] = -1
 * index 2: No element less than 2 in left of 2, G[2] = -1
 * index 3: No element less than 1 in left of 1, G[3] = -1
 */
public class NearestSmallerElement {

    public int[] prevSmaller(int[] A) {

        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
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

        int[] A = {4, 5, 2, 10, 8};
        NearestSmallerElement nse = new NearestSmallerElement();

        System.out.println("Result->" + Arrays.toString(nse.prevSmaller(A)));
    }
}
