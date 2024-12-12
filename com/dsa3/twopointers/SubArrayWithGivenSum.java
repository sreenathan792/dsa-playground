package com.dsa3.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 * <p>
 * <p>
 * If the answer does not exist return an array with a single integer "-1".
 * <p>
 * First sub-array means the sub-array for which starting index in minimum.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 5
 * Input 2:
 * <p>
 * A = [5, 10, 20, 100, 105]
 * B = 110
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * <p>
 * [2, 3]
 * Output 2:
 * <p>
 * [-1]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * [2, 3] sums up to 5.
 * Explanation 2:
 * <p>
 * No subarray sums up to required number.
 */
public class SubArrayWithGivenSum {

    public int[] solve(int[] A, int B) {

        int i = 0;
        int j = 0;
        int sum = A[0];
        int n = A.length;

        while (j < n) {

            if (sum == B) {

                ArrayList<Integer> ans = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    ans.add(A[k]);
                }

                return ans.stream().mapToInt(Integer::intValue).toArray();
            }

            if (sum < B) {
                j++;
                if (j == n) {
                    return new int[]{-1};
                }
                sum += A[j];
            } else {
                sum -= A[i];
                i++;
            }
        }

        return new int[]{-1};

    }

    public static void main(String[] args) {
        SubArrayWithGivenSum sg = new SubArrayWithGivenSum();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println("Subarray -> " + Arrays.toString(sg.solve(A, 5)));
    }

}
