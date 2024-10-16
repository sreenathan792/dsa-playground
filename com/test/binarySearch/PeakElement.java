package com.test.binarySearch;

/**
 * Given an array of integers A, find and return the peak element in it.
 * An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
 * <p>
 * NOTE:
 * <p>
 * It is guaranteed that the array contains only a single peak element.
 * Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 109
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
 * Return the peak element.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * <p>
 * 5
 * Output 2:
 * <p>
 * 100
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 5 is the peak.
 * Explanation 2:
 * <p>
 * 100 is the peak.
 */
public class PeakElement {

    public int solve(int[] A) {

        int n = A.length;
        int l = 0;
        int r = n-1;
        int ans = A[n-1];
        while(l<=r) {
            int mid = l+(r-l)/2;
            if((mid == 0 || A[mid-1] < A[mid]) && (mid == n-1 || A[mid+1] < A[mid])) {
                ans = A[mid];
            }
            if(mid == 0 || A[mid-1] < A[mid]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 17, 100, 11};
        PeakElement pe = new PeakElement();
        System.out.println("Peak Element = " + pe.solve(a));
    }
}
