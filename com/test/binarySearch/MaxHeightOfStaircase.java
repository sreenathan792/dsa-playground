package com.test.binarySearch;

/**
 * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
 * <p>
 * The first stair would require only one block, and the second stair would require two blocks, and so on.
 * <p>
 * Find and return the maximum height of the staircase.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= A <= 109
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the maximum height of the staircase using these blocks.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 10
 * Input 2:
 * <p>
 * A = 20
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The stairs formed will have height 1, 2, 3, 4.
 * Explanation 2:
 * <p>
 * The stairs formed will have height 1, 2, 3, 4, 5.
 */
public class MaxHeightOfStaircase {

    public int solve(int A) {

        int ans = 0;
        if(A == 0)
            return ans;

        long low = 1;
        long high = A;
        while(low<=high) {

            long mid = low + (high-low)/2;
            long maxBlocks = (mid * (mid+1))/2;
            if(maxBlocks<=A) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        MaxHeightOfStaircase max = new MaxHeightOfStaircase();
        System.out.println("Maximum Height -> " + max.solve(92761));
    }
}
