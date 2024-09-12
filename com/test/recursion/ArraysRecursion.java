package com.test.recursion;

/**
 * You are given an array A. Print the elements of the array using recursion.
 * <p>
 * NOTE :
 * You are required to not use any loops, You can create new functions.
 * Don't change the signature of the function PrintArray.
 * Print a new empty line after printing the output.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= | A | <= 100
 * -1000 <= A[i] <= 1000
 * <p>
 * <p>
 * Input Format
 * One line containing the array A
 * <p>
 * <p>
 * Output Format
 * Print the elements of the array in the sequential order.
 * <p>
 * <p>
 * Example Input
 * Input 1 :
 * A = [6, -2, 5, 3]
 * Input 2 :
 * A = [1]
 * <p>
 * <p>
 * Example Output
 * Output 1 :
 * 6 -2 5 3
 * Output 2 :
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Print the elements in their order.
 */
public class ArraysRecursion {

    public void PrintArray(int[] A) {
        printRec(A,0);
    }

    public void printRec (int[] A,int index) {
        if(index == A.length) {
            System.out.println("");
            return;
        }
        System.out.print(A[index] + " ");
        printRec(A, index+1);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        ArraysRecursion arrRec = new ArraysRecursion();
        arrRec.PrintArray(A);
    }
}
