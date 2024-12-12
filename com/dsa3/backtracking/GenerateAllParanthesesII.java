package com.dsa3.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 10
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a sorted list of all possible parenthesis.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * A = 1
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * Output 2:
 * <p>
 * [ "()" ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All paranthesis are given in the output list.
 * Explanation 2:
 * <p>
 * All paranthesis are given in the output list.
 */
public class GenerateAllParanthesesII {

    ArrayList<String> list = new ArrayList<>();
    public String[] generateParenthesis(int A) {

        solve("", A, 0, 0);
        return list.toArray(new String[0]);
    }

    private void solve(String str, int n, int open, int close) {

        if (open == n && close == n) {
            list.add(str);
            return;
        }

        if (open < n) {
            solve(str + "(", n, open + 1, close);
        }

        if (close < open) {
            solve(str + ")", n, open, close + 1);
        }
    }

    public static void main(String[] args) {

        GenerateAllParanthesesII gp = new GenerateAllParanthesesII();
        System.out.println("All Parantheses -> " + Arrays.toString(gp.generateParenthesis(3)));
    }
}
