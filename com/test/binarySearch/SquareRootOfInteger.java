package com.test.binarySearch;

/**
 * Given an integer A. Compute and return the square root of A.
 * If A is not a perfect square, return floor(sqrt(A)).
 * <p>
 * NOTE:
 * The value of A*A can cross the range of Integer.
 * Do not use the sqrt function from the standard library.
 * Users are expected to solve this in O(log(A)) time.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= A <= 109
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and only argument given is the integer A.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return floor(sqrt(A))
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 11
 * Input 2:
 * <p>
 * 9
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 * Explanatino 2:
 * When A = 9 which is a perfect square of 3, so we return 3.
 */
public class SquareRootOfInteger {
    public int sqrt(int A) {
        if(A==0)
            return 0;
        long l = 1;
        long r = A;
        long ans = 1;
        while(l<=r) {
            long mid = l + (r-l)/2;
            if(mid * mid <= A) {
                ans = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return (int) ans;

    }

    public static void main(String[] args) {
        SquareRootOfInteger sqrt = new SquareRootOfInteger();
        System.out.println("Square Root of Number = " + sqrt.sqrt(4));
    }
}
