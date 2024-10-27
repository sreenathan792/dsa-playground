package com.test.queue;

import com.test.stacks.BalancedParanthesis;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.
 * <p>
 * For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.
 * <p>
 * You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.
 * <p>
 * For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.
 * <p>
 * NOTE: If B > length of the array, return 1 element with the max of the array.
 * <p>
 * <p>
 * <p>
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
 * 1 <= |A|, B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an array C, where C[i] is the maximum value from A[i] to A[i+B-1].
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 3, -1, -3, 5, 3, 6, 7]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 * B = 6
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [3, 3, 5, 5, 6, 7]
 * Output 2:
 * <p>
 * [7, 7, 7, 7]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Window position     | Max
 * --------------------|-------
 * [1 3 -1] -3 5 3 6 7 | 3
 * 1 [3 -1 -3] 5 3 6 7 | 3
 * 1 3 [-1 -3 5] 3 6 7 | 5
 * 1 3 -1 [-3 5 3] 6 7 | 5
 * 1 3 -1 -3 [5 3 6] 7 | 6
 * 1 3 -1 -3 5 [3 6 7] | 7
 * Explanation 2:
 * <p>
 * Window position     | Max
 * --------------------|-------
 * [1 2 3 4 2 7] 1 3 6 | 7
 * 1 [2 3 4 2 7 1] 3 6 | 7
 * 1 2 [3 4 2 7 1 3] 6 | 7
 * 1 2 3 [4 2 7 1 3 6] | 7
 */
public class ParkingIceCreamTruck {

    public int[] slidingMaximum(final int[] A, int B) {

        int n = A.length;
        int[] res = new int[n-B+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < B; i++) {
            while (!queue.isEmpty() && A[queue.getLast()] < A[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        int c = 0;
        res[c++] = A[queue.getFirst()];

        for(int i = B; i<n; i++) {
            while (!queue.isEmpty() && A[queue.getLast()] < A[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if(queue.getFirst() == i-B){
                queue.removeFirst();
            }

            res[c++] = A[queue.getFirst()];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        int B = 3;
        ParkingIceCreamTruck pic = new ParkingIceCreamTruck();

        System.out.println("Result->" + Arrays.toString(pic.slidingMaximum(A, B)));
    }
}
