package com.test.trees;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
 * <p>
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of array <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a root node of the Binary Search Tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A : [1, 2, 3]
 * Input 2:
 * <p>
 * A : [1, 2, 3, 5, 10]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * /   \
 * 1     3
 * Output 2:
 * <p>
 * 3
 * /   \
 * 2     5
 * /       \
 * 1         10
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * You need to return the root node of the Binary Tree.
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(final int[] A) {

        int n = A.length;
        TreeNode ansNode = buildBST(A, 0, n-1);

        return ansNode;
    }

    private TreeNode buildBST(int[] A, int left, int right) {

        if (left>right)
            return null;

        int mid = left + (right-left)/2;
        TreeNode newNode = new TreeNode(A[mid]);
        newNode.left = buildBST(A,left,mid-1);
        newNode.right = buildBST(A,mid+1, right);

        return newNode;
    }

    public static void main(String[] args) {

        int[] nodes = {1, 4, 8};
        SortedArrayToBST construct = new SortedArrayToBST();
        System.out.println("Binary Tree -> " + construct.sortedArrayToBST(nodes));
    }
}
