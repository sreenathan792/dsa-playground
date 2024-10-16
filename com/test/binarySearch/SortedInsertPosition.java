package com.test.binarySearch;

import com.test.recursion.CountOfFactors;

/**
 * You are given a sorted array A of size N and a target value B.
 * Your task is to find the index (0-based indexing) of the target value in the array.
 * <p>
 * If the target value is present, return its index.
 * If the target value is not found, return the index of least element greater than equal to B.
 * If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
 * Your solution should have a time complexity of O(log(N)).
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * 1 <= A[i] <= 105
 * 1 <= B <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument is an integer array A of size N.
 * The second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the index of target value.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 3, 5, 6]
 * B = 5
 * Input 2:
 * <p>
 * A = [1, 4, 9]
 * B = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The target value is present at index 2.
 * Explanation 2:
 * <p>
 * The target value should be inserted at index 1.
 * <p>
 * <p>
 * <p>
 * Expected Output
 * Enter your input as per the following guideline:
 * There are 2 lines in the input
 * <p>
 * Line 1 ( Corresponds to arg 1 ) : An integer array. First number is the size S of the array. Then S numbers follow which indicate the elements in the array.
 * <p>
 * Line 2 ( Corresponds to arg 2 ) : A single integer
 */
public class SortedInsertPosition {

    public int searchInsert(int[] A, int B) {

        int n = A.length;
        int l = 0;
        int r = n-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(A[mid] == B || (mid != 0 && A[mid]>B && A[mid-1]<B)) {
                return mid;
            }
            if(A[mid]>B) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        if(A[0]>B){
            return 0;
        }

        return n;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9};
        int b = 3;
        SortedInsertPosition sip = new SortedInsertPosition();
        System.out.println("Sorted Insert Position of " + b + " = " + sip.searchInsert(a, b));
    }

}
