package com.dsa3.twopointers;

import java.util.Arrays;

/**
 * Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).
 * <p>
 * N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
 * <p>
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.
 * <p>
 * Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i] <= 105
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * Single Argument representing a 1-D array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return single Integer denoting the maximum area you can obtain.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 5, 4, 3]
 * Input 2:
 * <p>
 * A = [1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 6
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
 * So total area = 3 * 2 = 6
 * <p>
 * <p>
 * Explanation 2:
 * <p>
 * No container is formed.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] A) {

        int ans = 0;
        int n = A.length;
        int i = 0;
        int j = n-1;
        while (i<j) {
            int area = (j-i) * Math.min(A[i],A[j]);
            ans = Math.max(ans, area);

            if(A[i] < A[j]) {
                i++;
            } else if (A[i] > A[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ContainerWithMostWater co = new ContainerWithMostWater();
        int[] A = {1, 5, 4, 3};
        System.out.println("Area -> " + co.maxArea(A));
    }
}
