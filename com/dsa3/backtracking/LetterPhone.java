package com.dsa3.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a digit string A, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * <p>
 * <p>
 * The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 * <p>
 * NOTE: Make sure the returned strings are lexicographically sorted.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 10
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument is a digit string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a string array denoting the possible letter combinations.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = "23"
 * Input 2:
 * <p>
 * A = "012"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * Output 2:
 * <p>
 * ["01a", "01b", "01c"]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * There are 9 possible letter combinations.
 * Explanation 2:
 * <p>
 * Only 3 possible letter combinations.
 */
public class LetterPhone {

    Map<Integer,String> chMap = new HashMap<>();
    public String[] letterCombinations(String A) {

        chMap.put(0,"0");
        chMap.put(1,"1");
        chMap.put(2,"abc");
        chMap.put(3,"def");
        chMap.put(4,"ghi");
        chMap.put(5,"jkl");
        chMap.put(6,"mno");
        chMap.put(7,"pqrs");
        chMap.put(8,"tuv");
        chMap.put(9,"wxyz");
        ArrayList<String> ansList = new ArrayList<>();
        genComb(new StringBuilder(), 0, A.toCharArray(), ansList);

        String[] ansArr = new String[ansList.size()];
        ansArr = ansList.toArray(ansArr);

        return ansArr;
    }

    private void genComb(StringBuilder current, int index, char[] digits, ArrayList<String> ansList) {

        if(index == digits.length) {
            ansList.add(current.toString());
            return;
        }

        int digit = digits[index] - '0';
        for(int i = 0; i<chMap.get(digit).length(); i++) {
            current.append(chMap.get(digit).charAt(i));
            genComb(current, index+1, digits, ansList);
            current.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        LetterPhone lp = new LetterPhone();
        System.out.println("Letter Combinations -> " + Arrays.toString(lp.letterCombinations("23")));
    }
}
