package com.dsa4.graph;

import com.dsa4.dp.ZeroOneKnapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer A, you have to find the Ath Perfect Number.
 * <p>
 * A Perfect Number has the following properties:
 * <p>
 * It comprises only 1 and 2.
 * The number of digits in a Perfect number is even.
 * It is a palindrome number.
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a string that denotes the Ath Perfect Number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 22
 * Output 2:
 * <p>
 * 1111
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 2nd Perfect number.
 * Explanation 2:
 * <p>
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 3rd Perfect number.
 */
public class PerfectNumbers {

    public String solve(int A) {

        ArrayList<String> perfectNumberlist = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");

        while(!queue.isEmpty()) {

            String element = queue.poll();

            String perfectNo = element.concat(new StringBuilder(element).reverse().toString());
            perfectNumberlist.add(perfectNo);

            String e1 = element.concat("1");
            queue.offer(e1);

            String e2 = element.concat("2");
            queue.offer(e2);

            if(perfectNumberlist.size() == A)
                break;
        }

        return perfectNumberlist.get(perfectNumberlist.size()-1);
    }

    public static void main(String[] args) {

        PerfectNumbers perf = new PerfectNumbers();
        System.out.println("Ath Perfect Number -> " + perf.solve(4));
    }
}
