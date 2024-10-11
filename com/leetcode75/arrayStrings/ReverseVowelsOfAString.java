package com.leetcode75.arrayStrings;

import java.util.ArrayList;

/**
 * <h4>345. Reverse Vowels of a String</>
 * <p>
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "IceCreAm"
 * <p>
 * Output: "AceCreIm"
 * <p>
 * Explanation:
 * <p>
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * <p>
 * Output: "leotcede"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        int n = s.length();
        char[] chArray = s.toCharArray();

        ArrayList<Character> vowelArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (chArray[i] == 'a' || chArray[i] == 'e' || chArray[i] == 'i' || chArray[i] == 'o' || chArray[i] == 'u' ||
                    chArray[i] == 'A' || chArray[i] == 'E' || chArray[i] == 'I' || chArray[i] == 'O' || chArray[i] == 'U') {
                vowelArray.add(chArray[i]);
            }
        }

        int size = vowelArray.size();
        for (int i = 0; i < size / 2; i++) {
            char temp = vowelArray.get(i);
            char end = vowelArray.get(size - i - 1);
            vowelArray.set(size - i - 1, temp);
            vowelArray.set(i, end);
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (chArray[i] == 'a' || chArray[i] == 'e' || chArray[i] == 'i' || chArray[i] == 'o' || chArray[i] == 'u' ||
                    chArray[i] == 'A' || chArray[i] == 'E' || chArray[i] == 'I' || chArray[i] == 'O' || chArray[i] == 'U') {
                chArray[i] = vowelArray.get(k);
                k++;
            }
        }

        return new String(chArray);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString rs = new ReverseVowelsOfAString();
        System.out.println("Vowel Reversed String = " + rs.reverseVowels("IceCreAm"));
    }
}
