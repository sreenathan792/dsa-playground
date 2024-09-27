package com.test.QuickNComparator;

import com.test.CountNMerge.MergeSort;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.swap;

/**
 * Given an integer array A, sort the array using Quick Sort.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * <p>
 * Output Format
 * Return the sorted array.
 * <p>
 * <p>
 * Example Input
 * Input 1:-
 * A = [1, 4, 10, 2, 1, 5]
 * Input 2:-
 * A = [3, 7, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:-
 * [1, 1, 2, 4, 5, 10]
 * Output 2:-
 * [1, 3, 7]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1 and 2:
 * Return the sorted array.
 */
public class QuickSort {

    public int[] solve(int[] A) {

        int n = A.length;
        quickSort(A, 0, n-1);

        return A;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort(int[] A, int l, int r) {
        if(l>=r)
            return;
        int pivot = partition(A, l, r);
        quickSort(A,l,pivot-1);
        quickSort(A,pivot+1, r);
    }

    public int partition(int[] A, int l, int r) {
        int pivot = A[r];
        int i = l-1;
        for(int j = l; j<r; j++) {
            if(A[j]<pivot){
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1, r);

        return i+1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] A = {1, 4, 10, 2, 1, 5};
        System.out.println("Result -> " + Arrays.toString(qs.solve(A)));
    }
}
