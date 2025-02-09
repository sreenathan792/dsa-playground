package com.dsa4.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
 * Find the minimum possible largest element after B operations.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 104
 * 0 <= B <= 104
 * 1 <= A[i] <= 104
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument is an integer array A.
 * The second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the minimum possible largest element after B operations.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4]
 * B = 3
 * Input 2:
 * <p>
 * A = [5, 1, 4, 2]
 * B = 5
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
 * Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 * Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 * Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 * Minimum possible largest element after 3 operations is 4.
 * Explanation 2:
 * <p>
 * Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 * Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 * Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 * Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 * Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 * Minimum possible largest element after 5 operations is 5.
 */
public class MinimumLargestElement {

    public int solve(int[] A, int B) {

        int n = A.length;
        int[] modArr = Arrays.copyOf(A, n);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Pair(i, A[i] * 2));
        }

        for (int i = 0; i < B; i++) {
            Pair minVal = minHeap.poll();
            int newVal = minVal.value + A[minVal.index];
            modArr[minVal.index] = minVal.value;
            minHeap.offer(new Pair(minVal.index, newVal));
        }

        int maxVal = modArr[0];
        for (int i = 1; i < n; i++) {
            maxVal = Math.max(maxVal, modArr[i]);
        }

        return maxVal;
    }

    class Pair implements Comparable<Pair> {

        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.value, p.value);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        MinimumLargestElement minLarge = new MinimumLargestElement();
        System.out.println("Minimum Largest Element -> " + minLarge.solve(A, 3));
    }

}
