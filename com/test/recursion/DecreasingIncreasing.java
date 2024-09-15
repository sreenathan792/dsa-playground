package com.test.recursion;

/**
 * Print N numbers in Decreasing Order and then in Increasing Order.
 * <p>
 * You are given a positive number N.
 * You are required to print the numbers from N to 1.
 * You are required to not use any loops. Don't change the signature of the function DecThenInc function.
 * Note : Please print an new line after printing the output.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100
 * <p>
 * <p>
 * Input Format
 * The first line contains a single integer N.
 * <p>
 * <p>
 * Output Format
 * A single line having number printed from N to 1 and then from 1 to N.
 * <p>
 * <p>
 * Example Input
 * Input 2:
 * 1
 * Input 1:
 * 4
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 1 1
 * Output 2:
 * 4 3 2 1 1 2 3 4
 * <p>
 * <p>
 * Example Explanation
 * Elements are First printer from N down to 1 and then 1 upto N.
 */
public class DecreasingIncreasing {
    public void DecThenInc(int A) {
        printRec(A);
        System.out.println("");
    }

    public void printRec(int n) {
        if(n==0)
            return;
        System.out.print(n);
        printRec(n-1);
        System.out.print(n);
    }

    public static void main(String[] args) {
        DecreasingIncreasing sd = new DecreasingIncreasing();
        int A = 5;
        sd.DecThenInc(A);
    }
}
