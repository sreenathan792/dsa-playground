package com.test.arrays;

import com.leetcode75.arrayStrings.CanPlaceFlowers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
 * <p>
 * Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
 * A: For the purpose of this question, YES
 * Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
 * A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= size of the array <= 1000000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an array of digits.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the array of digits after adding one.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * [1, 2, 3]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 2, 4]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToNumber {

    public int[] plusOne(int[] A) {

        int n = A.length;
        int carry = 0;
        ArrayList<Integer> resArr = new ArrayList<>();
        if (A[n - 1] + 1 <= 9) {
            resArr.add(A[n - 1] + 1);
        } else {
            resArr.add(0);
            carry = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (A[i] + carry <= 9) {
                resArr.add(A[i] + carry);
                carry = 0;
            } else {
                resArr.add(0);
                carry = 1;
            }
        }
        if (carry == 1) {
            resArr.add(1);
        }
        Collections.reverse(resArr);
        int[] resultArray = resArr.stream().mapToInt(Integer::intValue).toArray();

        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (resultArray[i] != 0) {
                ind = i;
                break;
            }
        }
        if (ind > -1) {
            int[] shortArr =  new int[resultArray.length - ind];
            for (int i = 0; i < resultArray.length - ind; i++){
                shortArr[i] = resultArray[ind + i];
            }

            return shortArr;
        }

        return resultArray;
    }

    public static void main(String[] args) {
        AddOneToNumber ad = new AddOneToNumber();
        int[] A = {0, 0, 7, 0, 8, 9};
        System.out.println("Result -> " + Arrays.toString(ad.plusOne(A)));
    }
}
