package com.test.QuickNComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.
 * <p>
 * Note: You cannot use any extra space
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 104
 * 1 <= A[i] <= 104
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of integers.
 * <p>
 * <p>
 * Output Format
 * Return an array of integers.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [6, 8, 9]
 * Input 2:
 * A = [2, 4, 7]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * [9, 6, 8]
 * Output 2:
 * [2, 7, 4]
 * <p>
 * <p>
 * Example Explanation
 * For Input 1:
 * The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
 * For Input 2:
 * The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.
 */
public class FactorsSort {

    public int[] solve(int[] A) {
        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int factorsO1 = fact(o1);
                int factorsO2 = fact(o2);
                if (factorsO1 != factorsO2) {
                    return factorsO1-factorsO2;
                }

                return o1 - o2;
            }
        });

        int[] res = arr.stream().mapToInt(Integer::intValue).toArray();

        return res;
    }

    private int fact(Integer o1) {
        int count = 0;
        for (int i = 1; i * i <= o1; i++) {
            if (o1 % i == 0) {
                if (o1 / i == i)
                    count++;
                else
                    count += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FactorsSort ln = new FactorsSort();
        int[] A = {2, 4, 7};
        System.out.println("Result -> " + Arrays.toString(ln.solve(A)));
    }
}
