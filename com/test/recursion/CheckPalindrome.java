package com.test.recursion;

import java.util.Arrays;

/**
 * Write a recursive function that checks whether string A is a palindrome or Not.
 * Return 1 if the string A is a palindrome, else return 0.
 * <p>
 * Note: A palindrome is a string that's the same when read forward and backward.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 50000
 * <p>
 * String A consists only of lowercase letters.
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument is a string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if the string A is a palindrome, else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "naman"
 * Input 2:
 * <p>
 * A = "strings"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 */
public class CheckPalindrome {
    public int solve(String A) {
        if (isPalindrome(A, 0, A.length()-1)) {
            return 1;
        }

        return 0;
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return isPalindrome(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String A = "radar";
        CheckPalindrome check = new CheckPalindrome();
        System.out.println("Is Palindrome " + A + " ->" + check.solve(A));
    }
}
