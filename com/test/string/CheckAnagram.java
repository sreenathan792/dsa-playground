package com.test.string;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
 * <p>
 * Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * A and B are lowercase strings
 * <p>
 * <p>
 * Input Format
 * <p>
 * Both arguments A and B are a string.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if they are anagrams and 0 if not
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = "cat"
 * B = "bat"
 * Input 2:
 * A = "secure"
 * B = "rescue"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * 0
 * Output 2:
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * For Input 1:
 * The words cannot be rearranged to form the same word. So, they are not anagrams.
 * For Input 2:
 * They are an anagram.
 */
public class CheckAnagram {

    public int solve(String A, String B) {

        if (A.length() != B.length()) {
            return 0;
        }
        char[] aArr = A.toCharArray();
        char[] bArr = B.toCharArray();
        int n = aArr.length;

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (freqMap.get(aArr[i]) != null) {
                freqMap.put(aArr[i], freqMap.get(aArr[i]) + 1);
            } else {
                freqMap.put(aArr[i], 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (freqMap.get(bArr[j]) != null) {
                freqMap.put(bArr[j], freqMap.get(bArr[j]) - 1);
            } else {
                return 0;
            }
        }

        for(Map.Entry<Character, Integer> ent : freqMap.entrySet()) {
            if(ent.getValue() != 0) {
                return 0;
            }
        }

        return 1;
    }

    public static void main (String[] args) {
        String A = "silent";
        String B = "listen";
        CheckAnagram ca = new CheckAnagram();
        System.out.println("Check Anagram ->"+ ca.solve(A,B));
    }
}
