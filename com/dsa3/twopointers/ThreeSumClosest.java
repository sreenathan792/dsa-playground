package com.dsa3.twopointers;

import java.util.Arrays;

/**
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
 * <p>
 * Assume that there will only be one solution.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * -108 <= B <= 108
 * 1 <= N <= 104
 * -108 <= A[i] <= 108
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A of size N.
 * <p>
 * Second argument is an integer B denoting the sum you need to get close to.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a single integer denoting the sum of three integers which is closest to B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [-1, 2, 1, -4]
 * B = 1
 * Input 2:
 * <p>
 * <p>
 * A = [1, 2, 3]
 * B = 6
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * Explanation 2:
 * <p>
 * Take all elements to get exactly 6.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] A, int B) {

        Arrays.sort(A);
        int n = A.length;
        long minDiff = Integer.MAX_VALUE;
        long closeSum = A[0] + A[1] + A[2];
        for(int i = 0; i < n-2; i++) {

            int lf = i+1;
            int rt = n-1;
            while(lf<rt) {

                long sum = A[i] + A[lf] +A[rt];
                if(sum == B) {
                    return (int) sum;
                }

                if(sum<=B) {
                    lf++;
                } else {
                    rt--;
                }

                long difference = Math.abs(B-sum);
                if(difference<minDiff) {
                    minDiff = difference;
                    closeSum = sum;
                }

            }
        }

        return (int) closeSum;
    }

    public static void main(String[] args) {

        int[] A = {-1, 2, 1, -4};
        ThreeSumClosest ts = new ThreeSumClosest();
        System.out.println("Closest 3 sum -> " + ts.threeSumClosest(A, 1));
    }
}
