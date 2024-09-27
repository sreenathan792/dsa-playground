package com.test.CountNMerge;

import java.util.Arrays;

/**
 * Given an integer array A, sort the array using Merge Sort.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 * Output Format
 * Return the sorted array.
 *
 *
 * Example Input
 * Input 1:-
 * A = [1, 4, 10, 2, 1, 5]
 * Input 2:-
 * A = [3, 7, 1]
 *
 *
 * Example Output
 * Output 1:-
 * [1, 1, 2, 4, 5, 10]
 * Output 2:-
 * [1, 3, 7]
 *
 *
 * Example Explanation
 * Explanation 1 and 2:
 * Return the sorted array.
 */
public class MergeSort {

    public int[] solve(int[] A) {

        int n = A.length;
        System.out.println(Arrays.toString(A));
        sort(A,0,n-1);
        System.out.println(Arrays.toString(A));

        return A;
    }

    private void sort(int[] a , int l, int r) {

        if(l>=r)
            return;

        int mid = (l+r)/2;
        sort(a,l,mid);
        sort(a,mid+1,r);
        merge(a,l,mid,r);

    }

    private void merge(int[] A, int l, int mid, int r) {

        int n1 = mid-l+1;
        int n2 = r-mid;

        /*Array to store left half*/
        int[] B = new int[n1];
        /*Array to store right half*/
        int[] C = new int[n2];

        /*Populating left half*/
        int index = 0;
        for(int s = l; s<=mid; s++) {
            B[index] = A[s];
            index++;
        }

        /*Populating right half*/
        index = 0;
        for(int t = mid+1; t<=r; t++) {
            C[index] = A[t];
            index++;
        }

        /*Merging halfs*/
        int i = 0, j = 0;
        index = l;
        while(i<n1 && j<n2) {
            if(B[i]<=C[j]) {
                A[index] = B[i];
                index++;
                i++;
            } else {
                A[index] = C[j];
                index++;
                j++;
            }
        }

        while(i<n1) {
            A[index] = B[i];
            index++;
            i++;
        }

        while(j<n2) {
            A[index] = C[j];
            index++;
            j++;
        }

    }


    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] A = {1, 4, 10, 2, 1, 5};
        System.out.println("Result -> " + Arrays.toString(ms.solve(A)));
    }

}

