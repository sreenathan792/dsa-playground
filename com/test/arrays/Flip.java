package com.test.arrays;

import com.leetcode.arrays2D.KClosestToOrigin;

import java.util.Arrays;

/**
 * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
 * <p>
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 * <p>
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= size of string <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is a string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an array of integers denoting the answer.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = "010"
 * Input 2:
 * <p>
 * A = "111"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 1]
 * Output 2:
 * <p>
 * []
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * A = "010"
 * <p>
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | "110"
 * [1 2]          | "100"
 * [1 3]          | "101"
 * [2 2]          | "000"
 * [2 3]          | "001"
 * <p>
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 * Explanation 2:
 * <p>
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class Flip {

    public int[] flip(String A) {

        int[] res = new int[2];
        char[] chArr = A.toCharArray();
        int n = chArr.length;
        int l = 0;
        int r = 0;
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (chArr[i] == '1') {
                sum += -1;
            } else {
                sum += 1;
            }

            if (sum > maxSum) {
                maxSum = sum;
                res[0] = l + 1;
                res[1] = r + 1;
            }

            if (sum < 0) {
                sum = 0;
                l = i + 1;
                r = i + 1;
            } else {
                r = i + 1;
            }
        }

        if (maxSum == 0) {
            return new int[0];
        }

        return res;
    }

    public static void main(String[] args) {
        Flip kadane = new Flip();
        String A = "010";
        System.out.println("Flip = " + Arrays.toString(kadane.flip(A)));
    }
}
