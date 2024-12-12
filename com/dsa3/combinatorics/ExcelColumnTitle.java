package com.dsa3.combinatorics;

import java.util.Arrays;

/**
 * Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument of input contains single integer A
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a string denoting the corresponding title.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * <p>
 * A = 27
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * "C"
 * Output 2:
 * <p>
 * "AA"
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * <p>
 * 3 corrseponds to C.
 * Explanation 2:
 * <p>
 * 1 -> A,
 * 2 -> B,
 * 3 -> C,
 * ...
 * 26 -> Z,
 * 27 -> AA,
 * 28 -> AB
 */
public class ExcelColumnTitle {

    public String convertToTitle(int A) {

        String ans = "";
        while (A>0) {
            A = A-1;
            ans = (char) ('A' + A%26) + ans;
            A = A/26;
        }

        return ans;
    }

    public static void main(String[] args) {
        ExcelColumnTitle ex = new ExcelColumnTitle();
        System.out.println("Excel Column Title = " + ex.convertToTitle(40));
    }
}
