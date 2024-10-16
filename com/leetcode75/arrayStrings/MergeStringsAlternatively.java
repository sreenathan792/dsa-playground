package com.leetcode75.arrayStrings;

/**
 * <h4>1768. Merge Strings Alternately</h4>
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 * <p>
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 * <p>
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
public class MergeStringsAlternatively {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int shortLen = Math.min(word1.length(), word2.length());
        for(int i = 0; i<shortLen; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word1.length() > shortLen) {
            sb.append(word1.substring(shortLen));
        } else if (word2.length() > shortLen) {
            sb.append(word2.substring(shortLen));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternatively merge = new MergeStringsAlternatively();
        String st1 = "Affectionately";
        String st2 = "Yours";
        System.out.println("Result -> " + merge.mergeAlternately(st1, st2));
    }
}
