package com.test.CountNMerge;

import java.util.Arrays;

/**
 * An integer is given to you in the form of an array, with each element being a separate digit.
 * <p>
 * Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the digits of the given number in an array. Return the smallest number in the form an array.
 * <p>
 * Note - Do not use any sorting algorithm or library's sort method.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 ≤ N ≤ 105
 * <p>
 * 0 ≤ A[i] ≤ 9
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of length N, representing digits of the number.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the array representing the smallest possible number in form of an array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [6, 3, 4, 2, 7, 2, 1]
 * Input 2:
 * <p>
 * A = [4, 2, 7, 3, 9, 0]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 2, 3, 4, 6, 7]
 * Output 2:
 * <p>
 * [0, 2, 3, 4, 7, 9]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * It can be proved that a rearrangement for 6342721 cannot be smaller than 1223467.
 * Explanation 2:
 * <p>
 * Similarly, a rearrangement for 427390 cannot be smaller than 023479, i.e. 23479.
 */
public class SmallestNumber {

    public int[] smallestNumber(int[] A) {
        int n = A.length;
        int[] freq = new int[10];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
        }

        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < freq[i]; j++) {
                res[k++] = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SmallestNumber sn = new SmallestNumber();
        int[] A = {4, 2, 7, 3, 9, 0};
        System.out.println("Result -> " + Arrays.toString(sn.smallestNumber(A)));
    }
}
