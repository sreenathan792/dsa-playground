package com.test.binarySearch;

import java.util.Arrays;

/**
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 * <p>
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the largest minimum distance possible among the cows.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 * Explanation 2:
 * <p>
 * The minimum distance will be 1.
 */
public class AggressiveCows {

    public int solve(int[] A, int B) {

        Arrays.sort(A);
        int n = A.length;
        int l = 1;
        int r = A[n - 1] - A[0];

        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isPossible(mid, B, A)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int mid, int b, int[] a) {

        int count = 1;
        int i = 0, j = 0, n = a.length;
        while (j < n) {
            int nextPos = a[i] + mid;
            while (j < n && a[j] < nextPos)
                j++;

            if (j < n) {
                count++;
                i = j;
            }

        }

        return count >= b;
    }

    public int maxCows(int dist, int[] A) {
        int count = 1;
        int pos = A[0];
        int n = A.length;
        for (int i = 1; i < n; i++) {
            if (A[i] - pos >= dist) {
                count++;
                pos = A[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        AggressiveCows ac = new AggressiveCows();
        int[] A = {82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95};
        int B = 8;
        System.out.println("Minimum Distance between cows = " + ac.solve(A, B));
    }
}
