package com.dsa3.primenumbers;

import java.util.Arrays;

/**
 * A lucky number is a number that has exactly 2 distinct prime divisors.
 * <p>
 * You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 50000
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
 * Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 8
 * <p>
 * Input 2:
 * <p>
 * A = 12
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * <p>
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Between [1, 8] there is only 1 lucky number i.e 6.
 * 6 has 2 distinct prime factors i.e 2 and 3.
 * <p>
 * Explanation 2:
 * <p>
 * Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class LuckyNumbers {

    public int solve(int A) {

        int[] sieve = new int[A+1];
        for(int i = 2; i<=A; i++) {
            if(sieve[i] == 0) {
                for(int j = 2*i; j<=A; j+=i) {
                    sieve[j] = sieve[j]+1;
                }
            }
        }

        int count = 0;
        for(int i = 2; i<=A; i++) {
            if(sieve[i] == 2) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LuckyNumbers lk = new LuckyNumbers();
        System.out.println("Count of Lucky Numbers -> " + lk.solve(12));
    }
}
