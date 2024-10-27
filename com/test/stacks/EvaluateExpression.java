package com.test.stacks;

import com.test.arrays.ThreeFactors;

import java.util.Stack;

/**
 * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * <p>
 * Valid operators are +, -, *, /. Each string may be an integer or an operator.
 * <p>
 * Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is string array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 * A = ["4", "13", "5", "/", "+"]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * 9
 * Output 2:
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explaination 1:
 * starting from backside:
 * * : () * ()
 * 3 : () * (3)
 * + : (() + ()) * (3)
 * 1 : (() + (1)) * (3)
 * 2 : ((2) + (1)) * (3)
 * ((2) + (1)) * (3) = 9
 * Explaination 2:
 * starting from backside:
 * + : () + ()
 * / : () + (() / ())
 * 5 : () + (() / (5))
 * 13 : () + ((13) / (5))
 * 4 : (4) + ((13) / (5))
 * (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {

    public int evalRPN(String[] A) {

        Stack<String> st = new Stack<>();
        for (String ops : A) {
            if (ops.equals("+") || ops.equals("-") || ops.equals("*") || ops.equals("/")) {
                int y = Integer.parseInt(st.pop());
                int x = Integer.parseInt(st.pop());
                if (ops.equals("+")) {
                    int val = x + y;
                    st.push(String.valueOf(val));
                } else if (ops.equals("-")) {
                    int val = x - y;
                    st.push(String.valueOf(val));
                } else if (ops.equals("*")) {
                    int val = x * y;
                    st.push(String.valueOf(val));
                } else if (ops.equals("/")) {
                    int val = (y == 0) ? 0 : x / y;
                    st.push(String.valueOf(val));
                }
            } else {
                st.push(ops);
            }
        }

        return Integer.valueOf(st.peek());
    }

    public static void main(String[] args) {

        String[] A = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        EvaluateExpression ev = new EvaluateExpression();

        System.out.println("Result->" + ev.evalRPN(A));
    }
}
