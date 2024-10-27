package com.test.stacks;

import java.util.Stack;

/**
 * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
 * <p>
 * Refer to the examples for more clarity.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and the only argument of input contains the string A having the parenthesis sequence.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 0 if the parenthesis sequence is not balanced.
 * <p>
 * Return 1 if the parenthesis sequence is balanced.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = {([])}
 * Input 2:
 * <p>
 * A = (){
 * Input 3:
 * <p>
 * A = ()[]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * Output 3:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * You can clearly see that the first and third case contain valid paranthesis.
 * <p>
 * In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */
public class BalancedParanthesis {

    public int solve(String A) {

        char[] chArr = A.toCharArray();
        int n = chArr.length;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< n; i++) {
            if(chArr[i] == '{' || chArr[i] == '(' || chArr[i] == '[' ) {
                st.push(chArr[i]);
            } else {

                if(st.isEmpty())
                    return 0;
                char ch = st.pop();
                if(chArr[i] == ')' && ch != '(')
                    return 0;
                if(chArr[i] == ']' && ch != '[')
                    return 0;
                if(chArr[i] == '}' && ch != '{')
                    return 0;
            }
        }

        if(!st.isEmpty())
            return 0;

        return 1;
    }

    public static void main(String[] args) {

        String A = "(){";
        BalancedParanthesis bp = new BalancedParanthesis();

        System.out.println("Result->" + bp.solve(A));
    }
}
