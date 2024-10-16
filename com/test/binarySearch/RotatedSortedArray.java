package com.test.binarySearch;

import java.util.Arrays;

/**
 * Given a sorted array of integers A of size N and an integer B,
 * where array A is rotated at some pivot unknown beforehand.
 * <p>
 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 * <p>
 * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
 * <p>
 * You can assume that no duplicates exist in the array.
 * <p>
 * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 109
 * All elements in A are Distinct.
 * <p>
 * <p>
 * Input Format
 * <p>
 * The First argument given is the integer array A.
 * The Second argument given is the integer B.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return index of B in array A, otherwise return -1
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Input 2:
 * <p>
 * A : [ 9, 10, 3, 5, 6, 8 ]
 * B : 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Target 4 is found at index 0 in A.
 * Explanation 2:
 * <p>
 * Target 5 is found at index 3 in A.
 */
public class RotatedSortedArray {
    public int search(final int[] A, int B) {

        int n = A.length;
        // Sorted not Rotated
        if(A[0]<A[n-1]) {
            int l = 0;
            int r = n-1;
            while (l<=r) {
                int mid = l + (r-l)/2;
                if(A[mid] == B) {
                    return mid;
                }
                if(A[mid]<B) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        } else {

            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = l + (r-l)/2;
                if (A[mid] == B) {
                    return mid;
                }

                if (B < A[0]) { //B is in part 2

                    if (A[mid] < A[0]) { // A[mid] is in part2
                        if (A[mid] < B) {
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    } else { // A[mid] is in part1
                        l = mid + 1;
                    }


                } else { //B is in part 1

                    if (A[mid] > A[0]) { // A[mid] is in part1
                        if (A[mid] < B) {
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    } else { // A[mid] is in part2
                        r = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2, 3};
        int b = 4;
        RotatedSortedArray rsa = new RotatedSortedArray();
        System.out.println("Element Occurance = " + rsa.search(a, b));
    }
}
