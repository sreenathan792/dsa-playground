package com.leetcode75.arrayStrings;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <h4>151. Reverse Words in a String</h4>
 * <p>
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 * <p>
 * <p>
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {

        String[] strArr = s.trim().split("\\s+");
        int n = strArr.length;
        for(int i = 0; i<n/2; i++) {
            String temp = strArr[i];
            strArr[i] = strArr[n-i-1];
            strArr[n-i-1] = temp;
        }

        return String.join(" ", strArr);
    }

    public static void main(String[] args) {
        ReverseWordsInAString rw = new ReverseWordsInAString();
        System.out.println("Reverse Word String = " + rw.reverseWords("the  night is dark and full of terrors"));
    }
}
