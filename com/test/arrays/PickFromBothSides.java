package com.test.arrays;

/**
 * You are given an integer array A of size N.
 * <p>
 * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
 * <p>
 * Find and return the maximum possible sum of the B elements that were removed after the B operations.
 * <p>
 * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
 * <p>
 * Remove 3 elements from front and 0 elements from the back, OR
 * Remove 2 elements from front and 1 element from the back, OR
 * Remove 1 element from front and 2 elements from the back, OR
 * Remove 0 elements from front and 3 elements from the back.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * 1 <= B <= N
 * <p>
 * -103 <= A[i] <= 103
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the maximum possible sum of elements you removed.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * A = [5, -2, 3 , 1, 2]
 * B = 3
 * Input 2:
 * <p>
 * A = [ 2, 3, -1, 4, 2, 1 ]
 * B = 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * <p>
 * 8
 * Output 2:
 * <p>
 * 9
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 * Explanation 2:
 * <p>
 * Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
 */
public class PickFromBothSides {
    public int solve(int[] A, int B) {
        int n = A.length;
        int maxVal = 0;

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = A[0];
        for(int i = 1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        suffixSum[n-1] = A[n-1];
        for(int i = n-2; i>=0; i--) {
            suffixSum[i] = A[i] + suffixSum[i+1];
        }

        //Edge Case: all elements on left -> prefixSum[B], all elements on right -> suffixSum[n-B]
        maxVal = Math.max(prefixSum[B-1], suffixSum[n-B]);
        //Middle Cases from both ends
        for(int i = 1; i<B; i++) {
            int sum = prefixSum[i-1] + suffixSum[n-(B-i)];
            maxVal = Math.max(sum, maxVal);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        PickFromBothSides pbs = new PickFromBothSides();
        int[] A = {5, -2, 3, 1, 2};
        int B = 3;
        System.out.println("From both sides = " + pbs.solve(A, B));
    }
}
