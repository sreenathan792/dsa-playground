package com.test.modAthGCD;

/**
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 * <p>
 * Since the answer may be large, return the answer modulo (109 + 7).
 * <p>
 * Note: Ensure to handle integer overflow when performing the calculations.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 2
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = 28
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 * So total 4 pairs.
 * Explanation 2:
 * There is only one pair which is divisible by 28 is (17, 11)
 */
public class PairSumDivisible {

    public int solve(int[] A, int B) {
        int ans = 0;
        int n = A.length;
        int[] freqArr = new int[B];
        for (int i = 0; i < n; i++) {
            int val = A[i] % B;
            int pair;
            if(val == 0){
                pair = 0;
            } else {
                pair = B-val;
            }

            ans += freqArr[pair];
            freqArr[val]++;
        }

        return ans;
    }

    public static void main (String[] args) {
        int[] A = {1,2,3,4,5};
        int B = 2;
        PairSumDivisible psd = new PairSumDivisible();
        System.out.println("Count of pair sums ->"+psd.solve(A,B));
    }
}
