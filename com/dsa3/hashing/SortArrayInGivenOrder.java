package com.dsa3.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
 * For the elements not present in B, append them at last in sorted order.
 * <p>
 * Return the array A after sorting from the above method.
 * <p>
 * NOTE: Elements of B are unique.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the array A <= 100000
 * <p>
 * 1 <= length of the array B <= 100000
 * <p>
 * -10^9 <= A[i] <= 10^9
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is the integer array B.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the array A after sorting as described.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5, 4]
 * B = [5, 4, 2]
 * <p>
 * <p>
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = [1, 100]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [5, 4, 4, 2, 1, 3]
 * Output 2:
 * <p>
 * [100, 5, 11, 17]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Since 2, 4, 5, 4 of A are present in the array B.  So Maintaining the relative order of B.
 * Thus, [5, 4, 4, 2] and appending the remaining element (1, 3) in sorted order.
 * <p>
 * The Final array is [5, 4, 4, 2, 1, 3]
 * Explanation 2:
 * <p>
 * Since 100 of A are present in the array B.  So Maintaining the relative order of B.
 * Thus, [100] and appending the remaining element (5, 11, 17) in sorted order.
 * <p>
 * The Final array is [100, 5, 11, 17]
 */
public class SortArrayInGivenOrder {

    public int[] solve(int[] A, int[] B) {

        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(A[i])) {
                int freq = hm.get(A[i]);
                hm.put(A[i], freq + 1);
            } else {
                hm.put(A[i], 1);
            }
        }

        for (int j = 0; j < m; j++) {
            if (hm.containsKey(B[j])) {
                for (int k = 0; k < hm.get(B[j]); k++) {
                    res.add(B[j]);
                }
                hm.put(B[j], 0);
            }
        }

        for (Map.Entry<Integer, Integer> ent : hm.entrySet()) {
            if (ent.getValue() > 0) {
                for (int k = 0; k < ent.getValue(); k++) {
                    res.add(ent.getKey());
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        SortArrayInGivenOrder sort = new SortArrayInGivenOrder();
        int[] A = {3, 20, 17, 17};
        int[] B = {5, 9, 20, 11, 6, 18, 7, 13};
        System.out.println("Re-arranged Array -> " + Arrays.toString(sort.solve(A, B)));
    }
}
