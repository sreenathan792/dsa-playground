package com.leetcode75.arrayStrings;

/**
 * <h4>1071. Greatest Common Divisor of Strings</h4>
 * <p>
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
public class GcdOfString {

    public String gcdOfStrings(String str1, String str2) {

        if(str1.length()<str2.length()) {
            return gcdOfStrings(str2,str1);
        }
        if (str1.equals(str2)) {
            return str1;
        }
        if(str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()),str2);
        }

        return "";
    }

    public static void main(String[] args) {
        GcdOfString gcdString = new GcdOfString();
        String st1 = "ABABAB";
        String st2 = "ABAB";
        System.out.println("Result -> " + gcdString.gcdOfStrings(st1, st2));
    }
}
