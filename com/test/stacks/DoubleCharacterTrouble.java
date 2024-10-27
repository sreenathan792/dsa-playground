package com.test.stacks;

import java.util.Stack;

/**
 * You have a string, denoted as A.
 * <p>
 * To transform the string, you should perform the following operation repeatedly:
 * Identify the first occurrence of consecutive identical pairs of characters within the string.
 * Remove this pair of identical characters from the string.
 * Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
 * The final result will be the transformed string.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the final string.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * A = "abccbc"
 * <p>
 * Input 2:
 * <p>
 * <p>
 * A = "ab"
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * "ac"
 * Output 2:
 * <p>
 * "ab"
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The Given string is "abccbc".
 * <p>
 * Remove the first occurrence of consecutive identical pairs of characters "cc".
 * After removing the string will be "abbc".
 * <p>
 * Again Removing the first occurrence of consecutive identical pairs of characters "bb".
 * After remvoing, the string will be "ac".
 * <p>
 * Now, there is no consecutive identical pairs of characters.
 * Therefore the string after this operation will be "ac".
 * Explanation 2:
 * <p>
 * No removals are to be done.
 */
public class DoubleCharacterTrouble {

    public String solve(String A) {

        char[] chArr = A.toCharArray();
        int n = chArr.length;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< n; i++) {
            if(!st.isEmpty() && st.peek() == chArr[i]) {
                st.pop();
            } else {
                st.push(chArr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {

        String A = "abccbc";
        DoubleCharacterTrouble dct = new DoubleCharacterTrouble();

        System.out.println("Result->" + dct.solve(A));
    }
}
