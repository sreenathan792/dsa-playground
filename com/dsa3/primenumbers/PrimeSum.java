package com.dsa3.primenumbers;

import java.util.Arrays;

/**
 * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
 * <p>
 * If there is more than one solution possible, return the lexicographically smaller solution.
 * <p>
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 * [a, b] < [c, d], If a < c OR a==c AND b < d.
 * <p>
 * NOTE: A solution will always exist. Read Goldbach's conjecture.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 4 <= A <= 2*107
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument of input is an even number A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a integer array of size 2 containing primes whose sum will be equal to given number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * 4
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * [2, 2]
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * There is only 1 solution for A = 4.
 */
public class PrimeSum {

    public int[] primesum(int A) {

        boolean[] sieve = new boolean[A+1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        for(int i = 2; i*i <=A; i++) {
            if(sieve[i]) {
                for(int j = i*i; j<=A; j+=i) {
                    sieve[j] = false;
                }
            }
        }

        int[] res = new int[2];
        for(int i = 0; i<=A; i++) {
            if(sieve[i]) {
                int target = A-i;
                if(sieve[target]) {
                    res[0] = i;
                    res[1] = target;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PrimeSum ps = new PrimeSum();
        System.out.println("Prime Sum -> " + Arrays.toString(ps.primesum(10)));
    }
}
