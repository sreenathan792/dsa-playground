package com.test.arrays;

import java.util.Arrays;

/**
 * <h4>973. K Closest Points to Origin</h4>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * <p>
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= points.length <= 104
 * -104 <= xi, yi <= 104
 */
public class KClosestToOrigin {

    public int[][] kClosest(int[][] points, int k) {

        int n = points.length;
        int[] distArray = new int[n];
        for(int i = 0; i <n ; i++) {
            int x = points[i][0];
            int y = points[i][1];
            distArray[i] = (x*x) + (y*y);
        }

        Arrays.sort(distArray);
        //Distance of k closest element
        int distK = distArray[k-1];
        int[][] ans = new int[k][2];

        int c = 0;
        for(int i = 0; i<n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distComp = (x*x) + (y*y);
            if(distComp<=distK) {
                ans[c][0] = x;
                ans[c][1] = y;
                c++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        KClosestToOrigin eu = new KClosestToOrigin();
        int[][] A = {{3, 3}, {5, -1}, {-2, 4}};
        int B = 1;
        System.out.println("Closest = " + Arrays.deepToString(eu.kClosest(A, B)));
    }
}
