package com.test.binarySearch;

/**
 * You are given three positive integers, A, B, and C.
 * <p>
 * Any positive integer is magical if divisible by either B or C.
 * <p>
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * Note: Ensure to prevent integer overflow while calculating.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 109
 * <p>
 * 2 <= B, C <= 40000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is an integer A.
 * <p>
 * The second argument given is an integer B.
 * <p>
 * The third argument given is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 1
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * A = 4
 * B = 2
 * C = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 1st magical number is 2.
 * Explanation 2:
 * <p>
 * First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {

    private int MOD = 1000000007;
    public int solve(int A, int B, int C) {

        long low = 1;
        long high = (long) A * Math.min(B, C);
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = countOfMagicalNumbers(mid, B, C);
            if (count < A) {
                low = mid + 1;
            } else {
                ans = mid % MOD;
                high = mid - 1;
            }
        }

        if(ans<0) {
            ans += MOD;
        }

        return (int) ans;
    }

    private long countOfMagicalNumbers(long mid, int b, int c) {

        long lcm = (long) b * c / gcd(b, c);
        long count = mid / b + mid / c - mid / lcm;
        return count;
    }

    private long gcd(long a, long b) {

        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        AthMagicalNumber ath = new AthMagicalNumber();
        System.out.println("Ath Magical Number ->" + ath.solve(807414236, 3788, 38141));
    }
}
