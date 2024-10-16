package com.test.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
 * If so, return the integer. If not, return -1.
 * <p>
 * If there are multiple solutions, return any one.
 * <p>
 * Note: Read-only array means that the input array should not be modified in the process of solving the problem
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 7*105
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument is an integer array A.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * [1 2 3 1 1]
 * Input 2:
 * [1 2 3]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * 1
 * Output 2:
 * -1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * 1 occurs 3 times which is more than 5/3 times.
 * Explanation 2:
 * No element occurs more than 3 / 3 = 1 times in the array.
 */
public class Nby3RepeatingNumber {

    public int repeatedNumber(int[] A) {
        int n = A.length;
        if(n<3) {
            return -1;
        }
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i<n; i++) {
            if(freqMap.containsKey(A[i])) {
                freqMap.put(A[i], freqMap.get(A[i]) + 1);
            } else {
                freqMap.put(A[i], 1);
            }
        }
        int targetCount = n/3;
        for(Map.Entry<Integer, Integer> ent : freqMap.entrySet()) {
            if(ent.getValue()>targetCount) {
                return ent.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Nby3RepeatingNumber n3 = new Nby3RepeatingNumber();
        int[] A = {1, 2, 3, 1, 1};
        System.out.println("N/3 Repeating Element -> " + n3.repeatedNumber(A));
    }
}
