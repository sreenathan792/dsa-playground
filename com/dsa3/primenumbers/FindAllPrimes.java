package com.dsa3.primenumbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer A. Find the list of all prime numbers in the range [1, A].
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * Only argument A is an integer.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a sorted array of prime number in the range [1, A].
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = 7
 * Input 2:
 * A = 12
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * [2, 3, 5, 7]
 * Output 2:
 * [2, 3, 5, 7, 11]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * For Input 1:
 * The prime numbers from 1 to 7 are 2, 3, 5 and 7.
 * For Input 2:
 * The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
 */
public class FindAllPrimes {

    public int[] solve(int A) {

        boolean[] sieve = new boolean[A + 1];
        for (int i = 0; i <= A; i++) {
            sieve[i] = true;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i * i <= A; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= A; j += i) {
                    sieve[j] = false;
                }
            }
        }

        for (int i = 2; i <= A; i++) {
            if (sieve[i]) {
                res.add(i);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        FindAllPrimes fp = new FindAllPrimes();
        System.out.println("Primes -> " + Arrays.toString(fp.solve(100)));
    }
}
