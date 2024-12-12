package com.dsa3.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 * <p>
 * NOTE:
 * <p>
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 9
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * Only argument is an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a 2-D array denoting all possible permutation of the array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * A = [1, 2, 3]
 * <p>
 * <p>
 * Example Output
 * <p>
 * [ [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1] ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * All the possible permutation of array [1, 2, 3].
 */
public class Permutations {

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<Integer> ansList = new ArrayList<>();
        ArrayList<Boolean> visit = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            visit.add(i, false);
            ansList.add(0);
        }
        generatePermutations(A, 0, ansList, visit);

        return list;
    }

    private void generatePermutations(ArrayList<Integer> A, int i, ArrayList<Integer> ansList, ArrayList<Boolean> visit) {

        int n = A.size();
        if (i == n) {
            ArrayList<Integer> copy = new ArrayList<>(ansList);
            list.add(copy);
            return;
        }

        for (int j = 0; j < n; j++) {

            if (visit.get(j) == false) {
                ansList.set(i, A.get(j));
                visit.set(j, true);
                generatePermutations(A, i + 1, ansList, visit);
                visit.set(j, false);
            }
        }
    }

    public static void main(String[] args) {

        Permutations per = new Permutations();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println("Permutations -> " + per.permute(A).toString());
    }
}
