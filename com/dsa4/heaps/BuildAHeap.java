package com.dsa4.heaps;

import java.util.Arrays;

/**
 * Given an array A of N integers, convert that array into a min heap and return the array.
 * <p>
 * NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 ≤ N ≤ 105
 * <p>
 * 0 ≤ A[i] ≤ 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument of input contains a single integer array A of length N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the reordered array A such that it forms a min heap.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input:
 * <p>
 * A = [5, 13, -2, 11, 27, 31, 0, 19]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output:
 * <p>
 * A = [-2, 5, 0, 13, 11, 19, 27, 31]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * One possible Heap is
 * <p>
 * -2
 * /    \
 * 5       0
 * / \    /  \
 * 13  11  19   27
 * /
 * 31
 * <p>
 * It can be seen that each parent has a value smaller than its children. Hence it is a Valid Heap.
 * <p>
 * The Heap in the Array format is [-2, 5, 0, 13, 11, 19, 27, 31].
 * <p>
 * Some more possible heaps are  [-2, 0, 5, 13, 11, 27, 19, 31], [-2, 5, 0, 11, 27, 13, 19, 31], etc.
 * You can return any possible Valid Heap Structure.
 */
public class BuildAHeap {

    public int[] buildHeap(int[] A) {

        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, i, n);
        }

        return A;
    }

    private void heapify(int[] A, int i, int n) {

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && A[left] < A[smallest]) {
            smallest = left;
        }

        if (right < n && A[right] < A[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = A[smallest];
            A[smallest] = A[i];
            A[i] = temp;
            heapify(A, smallest, n);
        }
    }

    public static void main(String[] args) {
        int[] A = {5, 13, -2, 11, 27, 31, 0, 19};
        BuildAHeap build = new BuildAHeap();
        System.out.println("Heapified Array -> " + Arrays.toString(build.buildHeap(A)));
    }
}
