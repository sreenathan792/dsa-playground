package com.test.comparator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
 * <p>
 * If a number has no tens digit, we can assume value to be 0.
 * If 2 numbers have same tens digit, in that case number with max value will come first
 * Solution should be based on comparator.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument A is an array of integers.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the array after sorting
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = [15, 11, 7, 19]
 * Input 2:
 * A = [2, 24, 22, 19]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * [7, 19, 15, 11]
 * Output 2:
 * [2, 19, 24, 22]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * For Input 1:
 * The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0,
 * and that of 19, 15 and 11 is 1.
 * For Input 2:
 * The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0,
 * that of 19 is 1 and that of 22 and 24 is 2.
 */
public class TensDigitSorting {

    public int[] solve(int[] A) {

        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int fTens = getTensDigit(o1);
                int gTens = getTensDigit(o2);

                if(fTens != gTens) {
                    return fTens - gTens;
                }

                return o1 - o2;
            }
        });

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getTensDigit(int n) {

        if(n<10)
            return 0;

        return (n/10)%10;
    }

    public static void main(String[] args) {
        TensDigitSorting tds = new TensDigitSorting();
        int[] A = {15, 11, 7, 19};
        System.out.println("Tens Digit Sorted ->" + Arrays.toString(tds.solve(A)));
    }
}
