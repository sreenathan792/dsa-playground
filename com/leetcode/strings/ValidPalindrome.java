package com.leetcode.strings;

/**
 * <h4>125. Valid Palindrome</h4>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        s = s.trim().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return s.equals(sb.toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome vp = new ValidPalindrome();

        System.out.println("Is valid palindrome -> " + vp.isPalindrome(s));
    }

}
