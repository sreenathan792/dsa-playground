package com.test.binarySearch;

import java.util.Arrays;

/**
 * Given an array of integers A of size N and an integer B.
 * <p>
 * In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
 * <p>
 * Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
 * If there are several such numbers, your task is to find the minimum one.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * -109 <= A[i] <= 109
 * <p>
 * 0 <= B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an array C of size 2, where C[0] is number of occurence and C[1] is the number with maximum occurence.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [3, 1, 2, 2, 1]
 * B = 3
 * Input 2:
 * <p>
 * A = [5, 5, 5]
 * B = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [4, 2]
 * Output 2:
 * <p>
 * [3, 5]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Apply operations on A[2] and A[4]
 * A = [3, 2, 2, 2, 2]
 * Maximum occurence =  4
 * Minimum value of element with maximum occurence = 2
 * Explanation 2:
 * <p>
 * A = [5, 5, 5]
 * Maximum occurence =  3
 * Minimum value of element with maximum occurence = 5
 */
public class AddOrNot {

    public int[] solve(int[] A, int B) {

        Arrays.sort(A);
        int n = A.length;
        int[] prefArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefArray[i + 1] = prefArray[i] + A[i];
        }

        int max = Integer.MIN_VALUE;
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {

            int low = i;
            int high = i + 1;
            while (low <= high) {
                int count = low + (high - low) / 2;
                if (check(A, prefArray, B, count, i)) {
                    max = count;
                    low = count + 1;
                } else {
                    high = count - 1;
                }
            }

            if (ans[0] < max) {
                ans[0] = max;
                ans[1] = A[i];
            }

        }


        return ans;
    }

    private boolean check(int[] A, int[] prefArray, int B, int count, int i) {

        if ((A[i] * count) - (prefArray[i + 1] - prefArray[i - count + 1]) <= B) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        AddOrNot add = new AddOrNot();
        int[] A = {-5, 6, 1, -5, 1, -3, 1, 3, 1, 5};
        int B = 9;
        System.out.println("No with max occurance after addition -> " + Arrays.toString(add.solve(A, B)));
    }
}
