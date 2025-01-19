package com.dsa4.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Flipkart is currently dealing with the difficulty of precisely estimating and displaying the expected delivery time for orders to a specific pin code. The existing method relies on historical delivery time data for that pin code, using the median value as the expected delivery time. As the order history expands with new entries, Flipkart aims to enhance this process by dynamically updating the expected delivery time whenever a new delivery time is added. The objective is to find the expected delivery time after each new element is incorporated into the list of delivery times. End Goal: With every addition of new delivery time, requirement is to find the median value.
 * <p>
 * Why Median ? The median is calculated because it provides a more robust measure of the expected delivery time The median is less sensitive to outliers or extreme values than the mean. In the context of delivery times, this is crucial because occasional delays or unusually fast deliveries (outliers) can skew the mean significantly, leading to inaccurate estimations.
 * <p>
 * <p>
 * Given an array of integers, A denoting the delivery times for each order. New arrays of integer B and C are formed, each time a new delivery data is encountered, append it at the end of B and append the median of array B at the end of C. Your task is to find and return the array C.
 * <p>
 * NOTE:
 * <p>
 * If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
 * If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer array C, C[i] denotes the median of the first i delivery times.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 5, 4, 3]
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 1, 2, 2, 3]
 * Output 2:
 * <p>
 * [5, 5, 17, 11]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * <p>
 * <p>
 * Delivery Times      median
 * [1]                   1
 * [1, 2]                1
 * [1, 2, 5]             2
 * [1, 2, 5, 4]          2
 * [1, 2, 5, 4, 3]       3
 * Explanation 2:
 * <p>
 * Delivery Times     median
 * [5]                  5
 * [5, 17]              5
 * [5, 17, 100]         17
 * [5, 17, 100, 11]     11
 */
public class RunningMedian {

    public int[] solve(int[] A) {

        int n = A.length;
        int[] res = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(A[0]);
        res[0] = A[0];

        for (int i = 1; i < n; i++) {

            if (A[i] <= maxHeap.peek()) {
                maxHeap.offer(A[i]);
            } else {
                minHeap.offer(A[i]);
            }

            int sizeDiff = maxHeap.size() - minHeap.size();
            if (sizeDiff > 1) {
                minHeap.offer(maxHeap.poll());
            } else if (sizeDiff < 0) {
                maxHeap.offer(minHeap.poll());
            }

            res[i] = maxHeap.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {59, 64, 10, 39};
        RunningMedian med = new RunningMedian();
        System.out.println("Median -> " + Arrays.toString(med.solve(A)));
    }
}
