package com.dsa3.backtracking;

import java.util.ArrayList;

/**
 * Given a set of distinct integers A, return all possible subsets that can be formed from the elements of array A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 ≤ |A| ≤ 16
 * <p>
 * INT_MIN ≤ A[i] ≤ INT_MAX
 * <p>
 * Array A is given in increasing order.
 * <p>
 * All elements of array A are distinct.
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument of input contains a single integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a vector of vectors denoting the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1]
 * Input 2:
 * <p>
 * A = [1, 2, 3]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [
 * []
 * [1]
 * ]
 * Output 2:
 * <p>
 * [
 * []
 * [1]
 * [1, 2]
 * [1, 2, 3]
 * [1, 3]
 * [2]
 * [2, 3]
 * [3]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation:
 * <p>
 * You can see that these are all possible subsets.
 */
public class GenerateSubsets {

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        generateSubsets(A, 0, new ArrayList<Integer>());

        return list;
    }

    private void generateSubsets(ArrayList<Integer> A, int i, ArrayList<Integer> currSet) {

        if (i == A.size()) {
            list.add(currSet);
            return;
        }

        ArrayList<Integer> currSet1 = new ArrayList<>(currSet);
        currSet1.add(A.get(i));
        generateSubsets(A, i + 1, currSet1);
        generateSubsets(A, i + 1, currSet);
    }

    public static void main(String[] args) {

        GenerateSubsets gs = new GenerateSubsets();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(6);
        A.add(9);
        System.out.println("Subsets -> " + gs.subsets(A).toString());
    }
}
