package com.test.hashing;

import java.util.HashSet;

/**
 * Given an Array of integers B, and a target sum A.
 * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Length of array B <= 105
 * 0 <= Bi <= 109
 * 0 <= A <= 109
 * <p>
 * <p>
 * Input Format
 * First argument A is the Target sum, and second argument is the array B
 * <p>
 * <p>
 * Output Format
 * Return an integer value 1 if there exists such pair, else return 0.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 8
 * B = [3, 5, 1, 2, 1, 2]
 * Input 2:
 * <p>
 * A = 21
 * B = [9, 10, 7, 10, 9, 1, 5, 1, 5]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Example 1:
 * It is possible to obtain sum 8 using 3 and 5.
 * Example 2:
 * There is no such pair exists.
 */
public class CheckPairSum {

    public int solve(int A, int[] B) {

        int n = B.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i<n; i++){
            if(hs.contains(A-B[i])) {
                return 1;
            }
            hs.add(B[i]);
        }

        return 0;
    }

    public static void main(String[] args) {
        CheckPairSum cpS = new CheckPairSum();
        int A = 8;
        int[] B = {3, 5, 1, 2, 1, 2};
        System.out.println("Result -> " + cpS.solve(A, B));
    }
}
