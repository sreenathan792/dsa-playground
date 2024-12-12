package com.dsa3.primenumbers;

import java.util.Arrays;

/**
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * NOTE: The order of the resultant array should be the same as the input array.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the count of divisors of each element of the array in the form of an array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [8, 9, 10]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [2, 2, 3, 2]
 * Output 1:
 * <p>
 * [4, 3, 4]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 * So the count will be [2, 2, 3, 2].
 * Explanation 2:
 * <p>
 * The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 * So the count will be [4, 3, 4].
 */
public class CountOfDivisors {

    public int[] solve(int[] A) {

        int[] smallestPrimeFactor = new int[1000001];
        for (int i = 1; i < 1000001; i++) {
            smallestPrimeFactor[i] = i;
        }
        for (int i = 2; i * i < 1000001; i++) {

            for (int j = i * i; j < 1000001; j += i) {
                if (smallestPrimeFactor[j] == j) {
                    smallestPrimeFactor[j] = i;
                }
            }
        }

        int n = A.length;
        int[] divCount = new int[n];
        for(int i = 0; i<n; i++) {

            int temp = A[i];
            int ans = 1;
            while (temp != 1) {
                int count = 1;
                int spf = smallestPrimeFactor[temp];

                while (temp != 1 && temp%spf == 0) {
                    count++;
                    temp = temp/spf;
                }

                ans *= count;
            }

            divCount[i] = ans;
        }

        return divCount;
    }

    public static void main(String[] args) {
        CountOfDivisors cd = new CountOfDivisors();
        int[] A = {2, 3, 4, 5};
        System.out.println("Count of Divisors = " + Arrays.toString(cd.solve(A)));
    }
}
