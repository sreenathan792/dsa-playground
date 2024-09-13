package com.test.recursion;

import java.util.Arrays;

/**
 * Problem Description
 * Given an array of integers A with N elements and a target integer B, the task is to find all the indices at which B occurs in the array.
 * <p>
 * Note: The problem encourages recursive logic for learning purposes. Although the online judge doesn't enforce recursion, it's recommended to use recursive solutions to align with the question's spirit.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 103
 * 1 <= A[i] <= 103
 * 1 <= B <= 103
 * It is guaranteed that the target B, exist atleast once in the Array A.
 * <p>
 * <p>
 * Input Format
 * First Argument in an Array of Integers, A.
 * Second Argument is the Target, B.
 * <p>
 * <p>
 * Output Format
 * Return the sorted array of indices.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 1
 * Input 2:
 * A = [8, 9, 5, 6, 5, 5]
 * B = 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * [0]
 * Output 2:
 * [2, 4, 5]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * The Target, 1 occurs on Index = 0.  So returning [0]
 * Explanation 2:
 * Here, the target 5 occurs at indexes [2, 4, 5].
 */
public class AllIndicesOfArray {

    public int[] allIndices(int[] A, int B) {

        int[] ans = find(A, B, 0, 0);
        return ans;
    }

    public int[] find(int[] A, int B, int index, int count) {

        if (A.length == index) {
            return new int[count];
        }

        int[] ans;
        if (A[index] == B) {
            ans = find(A, B, index + 1, count + 1);
            ans[count] = index;
        } else {
            ans = find(A, B, index + 1, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {8, 9, 5, 6, 5, 5};
        int B = 5;
        AllIndicesOfArray allIn = new AllIndicesOfArray();
        System.out.println("Result Array ->" + Arrays.toString(allIn.allIndices(A, B)));
    }

}
