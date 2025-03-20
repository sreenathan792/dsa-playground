package com.test.comparator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an array of integers.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string representing the largest number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 30, 34, 5, 9]
 * Input 2:
 * <p>
 * A = [2, 3, 9, 0]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "9534330"
 * Output 2:
 * <p>
 * "9320"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 * Explanation 2:
 * <p>
 * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
public class LargestNumber {

    public String largestNumber(int[] A) {

        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String o1o2 = String.valueOf(o1) + String.valueOf(o2);
                String o2o1 = String.valueOf(o2) + String.valueOf(o1);

                if(o1o2.compareTo(o2o1)>0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Integer i : arr) {
            sb.append(i);
        }

        if(sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] A = {9, 5, 34, 3, 30};
        System.out.println("Result -> " + ln.largestNumber(A));
    }
}
