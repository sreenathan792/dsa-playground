package com.test.binarySearch;

/**
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 * <p>
 * 1 <= B <= 10^9
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
 * Return the maximum value of K (sub array length).
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = 130
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
 * For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
 * For K = 3, There is a subarray [3, 4, 5] which has a sum > B
 * For K = 2, There were no subarray which has a sum > B.
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 * <p>
 * For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
 * For K = 3, There were no subarray which has a sum > B.
 * Constraints are satisfied for maximal value of 3.
 */
public class SpecialInteger {

    public int solve(int[] A, int B) {

        int n = A.length;
        int low = 0;
        int high = n;
        int ans = n;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(check(A, B, mid)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }

    public boolean check(int[] A, int B, int mid) {

        int n = A.length;
        int sum = 0;
        for(int i = 0; i<mid; i++) {
            sum += A[i];
        }

        if(sum>B)
            return false;

        int i = 1;
        int j = mid;
        while(j<n) {
            sum = sum + A[j] - A[i-1];
            if(sum>B)
                return false;

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        SpecialInteger sp = new SpecialInteger();
        int[] A = {1, 2, 3, 4, 5};
        int B = 10;
        System.out.println("Max Value where subarrays are not present = " + sp.solve(A, B));
    }

    public int solveTwoPointers(int[] A, int B) {

        int n = A.length;
        int i = 0;
        int j = i+1;
        int ans = 1;
        


        return ans;
    }

}
