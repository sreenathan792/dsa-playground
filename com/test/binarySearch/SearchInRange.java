package com.test.binarySearch;

import java.util.Arrays;

/**
 * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
 * <p>
 * Return an array of size 2, such that
 * First element = Left most index of B in A
 * Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 * <p>
 * Note : Note: The time complexity of your algorithm must be O(log n)..
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 106
 * 1 <= A[i], B <= 109
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [5, 7, 7, 8, 8, 10]
 * B = 8
 * Input 2:
 * <p>
 * A = [5, 17, 100, 111]
 * B = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [3, 4]
 * Output 2:
 * <p>
 * [-1, -1]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The first occurrence of 8 in A is at index 3.
 * The last occurrence of 8 in A is at index 4.
 * ans = [3, 4]
 * Explanation 2:
 * <p>
 * There is no occurrence of 3 in the array.
 */
public class SearchInRange {

    public int[] searchRange(final int[] A, int B) {
        int n = A.length;
        int[] ans = new int[2];
        int leftIndex = -1;
        int rightIndex = -1;
        int l = 0;
        int r = n - 1;

        //first occurance
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == 0 || B > A[mid - 1]) && (A[mid] == B)) {
                leftIndex = mid;
                break;
            } else if (B > A[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        l = 0;
        r = n - 1;
        //last occurance
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == n - 1 || B < A[mid + 1]) && (A[mid] == B)) {
                rightIndex = mid;
                break;
            } else if (B < A[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        ans[0] = leftIndex;
        ans[1] = rightIndex;

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        int b = 8;
        SearchInRange se = new SearchInRange();
        System.out.println("Element Occurances = " + Arrays.toString(se.searchRange(a, b)));
    }
}
