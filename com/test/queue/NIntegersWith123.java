package com.test.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
 * <p>
 * <p>
 * NOTE: All the A integers will fit in 32-bit integers.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 29500
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * A = 7
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 2, 3, 11, 12, 13, 21]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 * Explanation 2:
 * <p>
 * Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
public class NIntegersWith123 {

    public int[] solve(int A) {

        int[] num = new int[A];
        Queue<Integer> queue = new LinkedList<>();
        if(A <= 3) {
            for(int i = 1; i<=A; i++) {
                num[i-1] = i;
            }

            return num;
        }

        int count = 0;
        queue.offer(1);
        num[count++] = 1;
        queue.offer(2);
        num[count++] = 2;
        queue.offer(3);
        num[count++] = 3;

        int i = 4;
        while (i<=A) {
            int x = queue.poll();

            int a = x*10+1;
            if(count == A) {
                break;
            }
            num[count++] = a;
            queue.offer(a);

            int b = x*10+2;
            if(count == A) {
                break;
            }
            num[count++] = b;
            queue.offer(b);

            int c = x*10+3;
            if(count == A) {
                break;
            }
            num[count++] = c;
            queue.offer(c);

            i += 3;
        }

        return num;
    }

    public static void main(String[] args) {

        NIntegersWith123 nInt = new NIntegersWith123();
        System.out.println("N Integers with 123 -> " + Arrays.toString(nInt.solve(8)));
    }
}
