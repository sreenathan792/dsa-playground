package com.test.string;

/**
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * <p>
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * <p>
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * <p>
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 6000
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
 * Return a string denoting the longest palindromic substring of string A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = "aaaabaaa"
 * Input 2:
 * A = "abba
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * "aaabaaa"
 * Output 2:
 * "abba"
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 * Explanation 2:
 * We can see that longest palindromic substring is of length 4 and the string is "abba".
 */
public class LongestPalindromeSubstring {

    public String longestPalindrome(String A) {

        char[] chArr = A.toCharArray();
        int n = chArr.length;
        int maxLen = 1;
        int start = 0;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<=1; j++) {
                int c1 = i;
                int c2 = i+j;
                while(c1>=0 && c2<n && chArr[c1] == chArr[c2]) {

                    int len = c2 - c1 + 1;
                    if(len>maxLen) {
                        start = c1;
                        maxLen = len;
                    }

                    c1--;
                    c2++;
                }
            }
        }

        return A.substring(start, start+maxLen);
    }

    public static void main (String[] args) {
        String A = "aaaabaaa";
        LongestPalindromeSubstring palin = new LongestPalindromeSubstring();
        System.out.println("LongestPalindromeSubstring ->"+ palin.longestPalindrome(A));
    }
}
