package com.dsa4.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
 * <p>
 * Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
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
 * 0 <= A[i] <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
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
 * A = [10, 2, 13, 4]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [-1, -1, 6, 24, 60]
 * Output 2:
 * <p>
 * [-1, -1, 260, 520]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * For i = 1, ans = -1
 * For i = 2, ans = -1
 * For i = 3, ans = 1 * 2 * 3 = 6
 * For i = 4, ans = 2 * 3 * 4 = 24
 * For i = 5, ans = 3 * 4 * 5 = 60
 * <p>
 * So, the output is [-1, -1, 6, 24, 60].
 * <p>
 * Explanation 2:
 * <p>
 * For i = 1, ans = -1
 * For i = 2, ans = -1
 * For i = 3, ans = 10 * 2 * 13 = 260
 * For i = 4, ans = 10 * 13 * 4 = 520
 * <p>
 * So, the output is [-1, -1, 260, 520].
 */
public class ProductOf3 {

    public int[] solve(int[] A) {

        int n = A.length;
        int[] resArr = new int[n];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {

            maxHeap.offer(A[i]);
            if (maxHeap.size() < 3) {
                resArr[i] = -1;
            } else {

                int largest = maxHeap.poll();
                int secondLargest = maxHeap.poll();
                int thirdLargest = maxHeap.poll();

                resArr[i] = largest * secondLargest * thirdLargest;
                maxHeap.offer(largest);
                maxHeap.offer(secondLargest);
                maxHeap.offer(thirdLargest);
            }
        }

        return resArr;
    }

    public static void main(String[] args) {

        ProductOf3 pr3 = new ProductOf3();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println("Result->" + Arrays.toString(pr3.solve(A)));
    }
}
