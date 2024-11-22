package com.test.trees;

import java.util.Arrays;

/**
 * Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
 * <p>
 * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
 * <p>
 * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 * <p>
 * Return 1 if it sum-binary tree else return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the array <= 100000
 * <p>
 * 0 <= node values <= 50
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the root node of tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if it is sum-binary tree else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 26
 * /    \
 * 10     3
 * /  \     \
 * 4   6      3
 * Input 2:
 * <p>
 * 26
 * /    \
 * 10     3
 * /  \     \
 * 4   6      4
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
 * All leaf nodes are considered as SumTree.
 * Value of Node 10 = 4 + 6.
 * Value of Node 3 = 0 + 3
 * Value of Node 26 = (10 + 4 + 6) + 6
 * Explanation 2:
 * <p>
 * Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.
 */

public class SumBinaryTree {

    public int solve(TreeNode A) {
        /*if(isBinarySumTree(A))
            return 1;

        return 0;*/

        return isSumTree(A);
    }

    private int isSumTree(TreeNode node) {

        //An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0
        if (node == null) {
            return 1;
        }

        //All leaf nodes are considered as SumTree.
        if (node.left == null && node.right == null) {
            return 1;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        if ((node.val == leftSum + rightSum) && (isSumTree(node.left) == 1) && (isSumTree(node.right) == 1)) {
            return 1;
        }

        return 0;

    }

    private boolean isBinarySumTree(TreeNode node) {

        //An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0
        if (node == null) {
            return true;
        }

        //All leaf nodes are considered as SumTree.
        if (node.left == null && node.right == null) {
            return true;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        if ((node.val == leftSum + rightSum) && isBinarySumTree(node.left) && isBinarySumTree(node.right)) {
            return true;
        }

        return false;
    }

    public int sum(TreeNode node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null)
            return node.val;

        return node.val + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {

        /*TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);
        node.right.right = new TreeNode(3);*/

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);

        SumBinaryTree sumBin = new SumBinaryTree();
        System.out.println("Is Binary Sum Tree -> " + sumBin.solve(node));

    }
}
