package com.leetcode75.bitManipulation;

import com.test.stacks.NearestSmallerElement;

import java.util.Arrays;

/**
 * <h4>338. Counting Bits</h4>
 * <p>
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 105
 * <p>
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
public class CountingBits {

    public int[] countBits(int n) {

        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = setBits(i);
        }

        return res;
    }

    public int setBits(int n) {

        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    public int[] countBitsOptimal(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            int temp = i;
            while (temp > 0) {
                temp = temp & (temp - 1);
                count++;
            }
            arr[i] = count;
        }

        return arr;
    }

    public static void main(String[] args) {

        CountingBits cb = new CountingBits();
        System.out.println("Result->" + Arrays.toString(cb.countBitsOptimal(5)));
    }

}
