package com.test.arrays;

import java.util.HashSet;

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

        String sNum = String.valueOf(A);
        int n = sNum.length();
        int noOfSubsequence = (n*(n+1))/2;
        HashSet<Integer> productSet = new HashSet<>();
        for(int i = 0; i<=n; i++) {
            for(int j = i+1; j<=n; j++) {
                int sub = Integer.parseInt(sNum.substring(i, j));
                System.out.println("Subsequence = " + sub);
                if(sub>10) {
                    int product = 1;
                    while (sub>0){
                        product *= sub%10;
                        sub /= 10;
                    }
                    productSet.add(product);
                } else {
                    productSet.add(sub);
                }

            }
        }

        if(productSet.size() == noOfSubsequence) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        ColorfulNumber cn = new ColorfulNumber();
        int A = 23;
        System.out.println("Result -> " + cn.colorful(A));
    }
}
