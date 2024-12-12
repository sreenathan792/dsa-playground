package com.dsa3.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an integer array A of size N.
 * <p>
 * <p>
 * You are also given an integer B, you need to find whether their exist a subset in A whose sum equal B.
 * <p>
 * If there exist a subset then return 1 else return 0.
 * <p>
 * Note : Sum of elements of an empty subset is 0.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 17
 * <p>
 * -109 <= A[i] <= 109
 * <p>
 * -109 <= B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if there exist a subset with sum B else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [3, 34, -3, 12, 5, 2]
 * B = 9
 * Input 2:
 * <p>
 * A = [-8, 34, 4, 0, -5, -2]
 * B = -20
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * There is a subset (-3, 12) with sum 9.
 * Explanation 2:
 * <p>
 * There is no subset that add up to -20.
 */

public class SubsetSumEqualsK {

    boolean flag = false;
    public int SubsetSum(ArrayList<Integer> A, int B) {

        if(B==0)
            return 1;

        generateSubSetSum(A, 0, B, new ArrayList<>());

        if (flag)
            return 1;

        return 0;
    }

    private void generateSubSetSum(ArrayList<Integer> A, int index, int B, ArrayList<Integer> currentSet) {

        if (index == A.size()) {

            Integer sum = currentSet.stream().collect(Collectors.summingInt(Integer::intValue));
            if (sum == B) {
                flag = true;
            }
            return;
        }

        currentSet.add(A.get(index));
        generateSubSetSum(A, index + 1, B, currentSet);
        currentSet.remove(currentSet.size() - 1);
        generateSubSetSum(A, index + 1, B, currentSet);
    }

    public static void main(String[] args) {

        SubsetSumEqualsK sum = new SubsetSumEqualsK();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 34, -3, 12, 5, 2));
        System.out.println("Check Subset Sum -> " + sum.SubsetSum(A, 9));
    }

}
