package com.test.binarySearch;

/**
 * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
 * <p>
 * Elements which are appearing twice are adjacent to each other.
 * <p>
 * NOTE: Users are expected to solve this in O(log(N)) time.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the single element that appears only once.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 1, 7]
 * Input 2:
 * <p>
 * A = [2, 3, 3]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 7
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 7 appears once
 * Explanation 2:
 * <p>
 * 2 appears once
 */
public class SingleElementInSortedArray {

   public int solve(int[] A) {
        int n = A.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if((mid == 0 || A[mid-1] != A[mid]) && (mid == n-1 || A[mid+1] != A[mid])) {
                 return A[mid];
            }

            if (mid == 0 || A[mid] != A[mid - 1]) {
                if (mid % 2 == 0)
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (mid % 2 == 0)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 4, 5, 5};
        SingleElementInSortedArray se = new SingleElementInSortedArray();
        System.out.println("Single Element = " + se.solve(a));
    }
}
