package com.dsa3.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given a number A, find if it is COLORFUL number or not.
 * <p>
 * If number A is a COLORFUL number return 1 else, return 0.
 * <p>
 * What is a COLORFUL Number:
 * <p>
 * A number can be broken into different consecutive sequence of digits.
 * The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
 * This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 2 * 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and only argument is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if integer A is COLORFUL else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 23
 * Input 2:
 * <p>
 * A = 236
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
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Possible Sub-sequences: [2, 3, 23] where
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6  (product of digits)
 * This number is a COLORFUL number since product of every digit of a sub-sequence are different.
 * Explanation 2:
 * <p>
 * Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 * 2 -> 2
 * 3 -> 3
 * 6 -> 6
 * 23 -> 6  (product of digits)
 * 36 -> 18  (product of digits)
 * 236 -> 36  (product of digits)
 * This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 */
public class ColorfulNumber {

    public int colorful(int A) {

        if (A < 10) {
            return 1;
        }

        List<Integer> numbers = new ArrayList<>();
        while (A > 0) {
            int num = A % 10;
            numbers.add(num);
            A /= 10;
        }
        Collections.reverse(numbers);
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i< numbers.size(); i++) {
            int prod = 1;
            for(int j = i; j< numbers.size(); j++) {
                prod *= numbers.get(j);
                if(hs.contains(prod)) {
                    return 0;
                } else {
                    hs.add(prod);
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        ColorfulNumber cln = new ColorfulNumber();
        System.out.println("Is Colorful Number -> " + cln.colorful(236));
    }
}
