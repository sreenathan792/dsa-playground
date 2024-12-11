package com.dsa3.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 20
 * <p>
 * 0 <= B < 2A - 1
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the Bth indexed symbol in row A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * B = 0
 * Input 2:
 * <p>
 * A = 4
 * B = 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Row 1: 0
 * Row 2: 01
 * Row 3: 0110
 * Explanation 2:
 * <p>
 * Row 1: 0
 * Row 2: 01
 * Row 3: 0110
 * Row 4: 01101001
 */
public class KthNumberEasy {

    public int solve(int A, int B) {

        List<Integer> arr = generateRows(A);
        return arr.get(B);
    }

    private List<Integer> generateRows(int a) {

        if(a==1) {
            return Arrays.asList(0);
        }

        List<Integer> arr = generateRows(a-1);
        List<Integer> newList = new ArrayList<>();
        for(int i = 0; i<arr.size(); i++) {

            if(arr.get(i) == 0) {
                newList.add(0);
                newList.add(1);
            } else {
                newList.add(1);
                newList.add(0);
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        KthNumberEasy kn = new KthNumberEasy();
        System.out.println("Kth Number -> " + kn.solve(4, 4));
    }
}
