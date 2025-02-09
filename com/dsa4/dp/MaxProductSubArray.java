package com.dsa4.dp;

/**
 * Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
 * <p>
 * Return an integer corresponding to the maximum product possible.
 * <p>
 * NOTE: Answer will fit in 32-bit integer value.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 5 * 105
 * <p>
 * -100 <= A[i] <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer corresponding to the maximum product possible.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [4, 2, -5, 1]
 * Input 2:
 * <p>
 * A = [-3, 0, -5, 0]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 8
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * We can choose the subarray [4, 2] such that the maximum product is 8.
 * Explanation 2:
 * <p>
 * 0 will be the maximum product possible.
 */
public class MaxProductSubArray {

    public int maxProduct(final int[] A) {

        int n = A.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMin[0] = A[0];
        dpMax[0] = A[0];

        for (int i = 1; i < n; i++) {

            dpMax[i] = Math.max(A[i], (Math.max(dpMin[i - 1] * A[i], dpMax[i - 1] * A[i])));
            dpMin[i] = Math.min(A[i], (Math.min(dpMin[i - 1] * A[i], dpMax[i - 1] * A[i])));
        }

        int ans = dpMax[0];
        for(int max: dpMax) {
            ans = Math.max(max, ans);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] A = {4, 2, -5, 1};
        MaxProductSubArray max = new MaxProductSubArray();
        System.out.println("Maximum Product -> " + max.maxProduct(A));
    }

}
