package com.dsa4.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * You have an empty min heap. You are given an array A consisting of N queries. Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:
 * <p>
 * P = 1, Q = -1 : Pop the minimum element from the heap.
 * P = 2, 1 <= Q <= 109 : Insert Q into the heap.
 * <p>
 * Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i][0] <= 2
 * <p>
 * 1 <= A[i][1] <= 109 or A[i][1] = -1
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument A is a 2D integer array
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer array
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [[1, -1], [2, 2], [2, 1], [1, -1]]
 * Input 2:
 * <p>
 * A = [[2, 5], [2, 3], [2, 1], [1, -1], [1, -1]]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [-1, 1]
 * Output 2:
 * <p>
 * [1, 3]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * For the first extract operation the heap is empty so it gives -1. For the second extract operation the heap contains the elements 2 and 1. Extract min returns the element 1.
 * Explanation 2:
 * <p>
 * The heap contains the elements 5, 3 and 1. The first extract min operation gets the element 1 and the second operation gets the element 3.
 */
public class HeapQueries {

    ArrayList<Integer> heap = new ArrayList<>();
    public int[] solve(int[][] A) {

        ArrayList<Integer> res = new ArrayList<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int oper = A[i][0];
            if (oper == 1) {
                int min = getMin();
                res.add(min);
            }
            if(oper == 2) {
                int val = A[i][1];
                insertToHeap(val);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void insertToHeap(int val) {

        heap.add(val);
        int i = heap.size()-1;
        while(i>0) {
            int parent = (i-1)/2;
            if(heap.get(parent)> heap.get(i)) {
                Collections.swap(heap, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    private int getMin() {

        if (heap.isEmpty())
            return -1;
        int min = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(0);

        return min;
    }

    private void heapify(int i) {

        int smallest = i;
        int n = heap.size();
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < n && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            heapify(smallest);
        }
    }

    public static void main(String[] args) {
        int[][] A = {{2, 5}, {2, 3}, {2, 1}, {1, -1}, {1, -1}};
        HeapQueries hq = new HeapQueries();
        System.out.println("Heap Query Result -> " + Arrays.toString(hq.solve(A)));
    }
}
