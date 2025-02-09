package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= |intervals| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is the vector of intervals
 * <p>
 * second argument is the new interval to be merged
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the vector of intervals after merging
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 * <p>
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [ [1, 5], [6, 9] ]
 * Output 2:
 * <p>
 * [ [1, 9] ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * (2,5) does not completely merge the given intervals
 * Explanation 2:
 * <p>
 * (2,6) completely merges the given intervals
 */
public class MergeIntervalsII {

    public int[][] insert(int[][] A, int[] B) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = A.length;

        // Add all intervals that come before the new interval
        while (i < n && A[i][1] < B[0]) {
            result.add(A[i]);
            i++;
        }

        // Merge the new interval with the overlapping intervals
        while (i < n && A[i][0] <= B[1]) {
            B[0] = Math.min(B[0], A[i][0]);
            B[1] = Math.max(B[1], A[i][1]);
            i++;
        }

        // Add the merged interval
        result.add(B);

        // Add all remaining intervals
        while (i < A.length) {
            result.add(A[i]);
            i++;
        }

        // Convert the list to an array
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        MergeIntervalsII mg = new MergeIntervalsII();
        int[][] A = {{1, 3}, {6, 9}};
        int[] B = {2, 6};
        System.out.println("Merged Interval = " + Arrays.deepToString(mg.insert(A, B)));
    }
}


