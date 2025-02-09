package com.dsa4.interviewproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings A and B of lengths m and n respectively, return the minimum window substring of A such that every character in B (including duplicates) is included in the window. If there is no such substring, return "-1".
 * <p>
 * When there are multiple answers, return the one which appears first in A.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * m == A.length
 * n == B.length
 * 1 <= m, n <= 105
 * A and B consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is a string A and second argument is a string B.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a string.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = "ADOBECODEBANC"
 * B = "ABC"
 * Input 2:
 * A = "abaca"
 * B = "aa"
 * Input 3:
 * A = "a"
 * B = "aa"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * "BANC"
 * Output 2:
 * "aba"
 * Output 3:
 * "-1"
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * The minimum window substring "BANC" includes 'A', 'B', and 'C' from string B.
 * Explanation 2:
 * Both "aba" and "aca" are the shortest substrings of A that contain all characters of B.
 * However, since "aba" appears before "aca" in A, we return "aba".
 * Explanation 3:
 * Both 'a's from B must be included in the window.
 * Since the largest window of A only has one 'a', return "-1".
 */
public class MinimumWindowSubstring {

    public String minWindow(String A, String B) {

        char[] chA = A.toCharArray();
        char[] chB = B.toCharArray();
        int n = chA.length;
        int m = chB.length;

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            mapB.put(chB[i], mapB.getOrDefault(chB[i], 0) + 1);
        }

        int l = 0;
        int r = 0;
        int minWindow = Integer.MAX_VALUE;
        int finalL = -1;
        int finalR = -1;
        while (r < n) {
            while (r < n && !isMatch(mapA, mapB)) {
                mapA.put(chA[r], mapA.getOrDefault(chA[r], 0) + 1);
                r++;
            }

            while (isMatch(mapA, mapB)) {

                if (r - l < minWindow) {
                    minWindow = r - l;
                    finalL = l;
                    finalR = r;
                }
                mapA.put(chA[l], mapA.get(chA[l]) - 1);
                if (mapA.get(chA[l]) == 0) {
                    mapA.remove(chA[l]);
                }
                l++;
            }
        }

        if (minWindow == Integer.MAX_VALUE)
            return "-1";

        return A.substring(finalL, finalR);
    }

    public boolean isMatch(HashMap<Character, Integer> mapA, HashMap<Character, Integer> mapB) {
        if (mapA.size() < mapB.size())
            return false;

        for (Map.Entry<Character, Integer> ent : mapB.entrySet()) {
            char key = ent.getKey();
            if (mapA.getOrDefault(key, 0) < mapB.get(key)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        MinimumWindowSubstring min = new MinimumWindowSubstring();
        System.out.println("Min Window Substring -> " + min.minWindow(A, B));
    }
}
