package com.test.binarySearch;

/**
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
 * <p>
 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 * <p>
 * Return the ans % 10000003.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 1000
 * 1 <= B <= 106
 * 1 <= N <= 105
 * 1 <= C[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer A.
 * The second argument given is the integer B.
 * The third argument given is the integer array C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 2
 * B = 5
 * C = [1, 10]
 * Input 2:
 * <p>
 * A = 10
 * B = 1
 * C = [1, 8, 11, 3]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 50
 * Output 2:
 * <p>
 * 11
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Possibility 1:- One painter paints both blocks, time taken = 55 units.
 * Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 * There are no other distinct ways to paint boards.
 * ans = 50 % 10000003
 * Explanation 2:
 * <p>
 * Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 * and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 * ans = 11 % 10000003
 */
public class PaintersPartitionProblem {

    public int paint(int A, int B, int[] C) {
        int n = C.length;
        long sum = 0;
        long maxVal = C[0];
        for (int i = 0; i < n; i++) {
            sum += C[i];
            maxVal = Math.max(maxVal, C[i]);
        }

        long low = ((maxVal % 10000003) * (B % 10000003)) % 10000003;
        long high = ((sum % 10000003) * (B % 10000003)) % 10000003;
        long ans = low;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = minPainters(mid, C, B);

            if (count <= A) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) (ans % 10000003);
    }


    public long minPainters(long mid, int[] C, int unitsOfTime) {
        int count = 1;
        long painterTime = mid;
        long totalBoardTime = 0;
        int n = C.length;
        for (int i = 0; i < n; i++) {
            totalBoardTime += C[i] * unitsOfTime;
            if (totalBoardTime > painterTime) {
                totalBoardTime = C[i] * unitsOfTime;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PaintersPartitionProblem pPrt = new PaintersPartitionProblem();
        int A = 1;
        int B = 1000000;
        int[] C = {1000000, 1000000};
        System.out.println("Minimum Time Taken by painters = " + pPrt.paint(A, B, C));
    }
}
