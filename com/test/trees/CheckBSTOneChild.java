package com.test.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= number of nodes <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is an integer array denoting the preorder traversal of binary tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a string "YES" if true else "NO".
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A : [4, 10, 5, 8]
 * Input 2:
 * <p>
 * A : [1, 5, 6, 4]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * "YES"
 * Output 2:
 * <p>
 * "NO"
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The possible BST is:
 * 4
 * \
 * 10
 * /
 * 5
 * \
 * 8
 * Explanation 2:
 * <p>
 * There is no possible BST which have the above preorder traversal.
 */
public class CheckBSTOneChild {

    public String solve(ArrayList<Integer> A) {

        int n = A.size();
        if (n == 1)
            return "YES";

        int L = Integer.MIN_VALUE;
        int R = Integer.MAX_VALUE;
        int root = A.get(0);
        for (int i = 1; i < n; i++) {
            if (root < A.get(i)) {
                L = root;
            } else {
                R = root;
            }

            if (A.get(i) < L || A.get(i) > R) {
                return "NO";
            }

            root = A.get(i);
        }

        return "YES";
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(List.of(4, 10, 5, 8));

        CheckBSTOneChild ckBST = new CheckBSTOneChild();
        System.out.println("Binary Tree Possible -> " + ckBST.solve(arr));
    }
}
