package com.test.binarySearch;

/**
 * Given an array A[] of n packages, the task is to find the least weight capacity of a boat to ship all Packages within B days.
 * The A[i] represent the weight of ith Package. Each day, we load the boat with packages without changing their order.
 * We may not load more weight than the maximum weight capacity of the boat.
 * Examples:
 * A = [1,2,3,4,5,6,7,8,9,10] , B = 5 => Output = 15
 * A = [1,2,3,1,1], B = 4 => Output = 4
 */
public class LeastCapacityToShip {

    public int solve(int[] A, int B) {

        int ans = 0;
        int n = A.length;
        int maxWeight = 0;
        int totalWeight = 0;
        for (int i = 0; i < n; i++) {
            totalWeight += A[i];
            maxWeight = Math.max(maxWeight, A[i]);
        }

        int lower = maxWeight;
        int higher = totalWeight;

        while (lower <= higher) {

            int mid = lower + (higher - lower) / 2;
            int days = 1;
            int weights = 0;
            for (int i = 0; i < n; i++) {
                weights += A[i];
                if (weights > mid) {
                    days++;
                    weights = A[i];
                }
            }

            if (days <= B) {
                ans = mid;
                higher = mid - 1;
            } else {
                lower = mid + 1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        LeastCapacityToShip lc = new LeastCapacityToShip();
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int B = 5;
        System.out.println("Minimum days for packages = " + lc.solve(A, B));
    }
}
