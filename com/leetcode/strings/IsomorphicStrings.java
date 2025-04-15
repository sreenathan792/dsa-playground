package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * <h4>205. Isomorphic Strings</h4>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * The strings s and t can be made identical by:
 * <p>
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * <p>
 * Output: false
 * <p>
 * Explanation:
 * <p>
 * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * <p>
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        int n = s.length();
        int m = t.length();

        if(n != m) {
            return false;
        }

        Map<Character, Character> charaMap = new HashMap<>();
        for(int i = 0; i<n; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if(charaMap.containsKey(sch)) {
                char rep = charaMap.get(sch);
                if(tch != rep) {
                    return false;
                }
            } else {
                if(charaMap.containsValue(tch)) {
                    return false;
                } else {
                    charaMap.put(sch, tch);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        String a = "badc";
        String b = "kikp";
        System.out.println("Is isomorphic ->" + is.isIsomorphic(a, b));
    }
}
