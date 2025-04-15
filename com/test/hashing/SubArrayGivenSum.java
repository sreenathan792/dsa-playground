package com.test.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class SubArrayGivenSum {

    public int[] solve(int[] A, int B) {

        int n = A.length;
        long[] prefSum = new long[n + 1];
        prefSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefSum[i] = prefSum[i - 1] + A[i - 1];
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, 0);

        int leftIndex = -1;
        int rightIndex = -1;

        for (int i = 1; i <= n; i++) {
            long target = prefSum[i] - B;
            if (hm.containsKey(target)) {
                leftIndex = hm.get(target);
                rightIndex = i;
                break;
            }
            hm.put(prefSum[i], i);
        }

        if (leftIndex != -1 && rightIndex != -1) {
            int[] result = new int[rightIndex - leftIndex];
            System.arraycopy(A, leftIndex, result, 0, rightIndex - leftIndex);
            return result;
        }

        return new int[] {-1};
    }

    public static void main(String[] args) {

        SubArrayGivenSum sub = new SubArrayGivenSum();
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;

        System.out.println("Subarray with given sum ->" + Arrays.toString(sub.solve(A, B)));
    }

}
