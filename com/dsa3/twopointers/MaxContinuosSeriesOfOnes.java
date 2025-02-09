package com.dsa3.twopointers;

/**
 * Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
 * <p>
 * For this problem, return the indices of maximum continuous series of 1s in order.
 * <p>
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= B <= 105
 * <p>
 * 1 <= size(A) <= 105
 * <p>
 * 0 <= A[i] <= 1
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an binary array A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 1, 0, 1, 1, 0, 0, 1, 1, 1]
 * B = 1
 * Input 2:
 * <p>
 * A = [1, 0, 0, 0, 1, 0, 1]
 * B = 2
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [0, 1, 2, 3, 4]
 * Output 2:
 * <p>
 * [3, 4, 5, 6]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
 * Explanation 2:
 * <p>
 * Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].
 */
public class MaxContinuosSeriesOfOnes {

    public int[] maxone(int[] A, int B) {

        return A;
    }

    public static void main(String[] args) {

        int[] A = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        MaxContinuosSeriesOfOnes maxOne = new MaxContinuosSeriesOfOnes();
        System.out.println("Max Continuos Series of Ones -> " + maxOne.maxone(A, 1));
    }
}
