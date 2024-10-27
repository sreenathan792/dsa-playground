package com.test.trees;

import javax.swing.*;

/**
 * Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= size of tree <= 100000
 * <p>
 * <p>
 * <p>
 * <p>
 * 0 <= value of node <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is head of tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * 5
 * /  \
 * 3    7
 * / \  / \
 * 4  6  5  6
 * Input 2:
 * <p>
 * <p>
 * 1
 * / \
 * 2   10
 * / \
 * 20  2
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
 * Remove edge between 5(root node) and 7:
 * Tree 1 =                                               Tree 2 =
 * 5                                                     7
 * /                                                     / \
 * 3                                                     5   6
 * / \
 * 4   6
 * Sum of Tree 1 = Sum of Tree 2 = 18
 * Explanation 2:
 * <p>
 * The given Tree cannot be partitioned.
 */
public class EqualTreePartition {

    public int solve(TreeNode A) {

        int totalSum = sum(A);
        if((totalSum&1) == 1)
            return 0;

        if(check(A, totalSum/2))
            return 1;

        return 0;
    }

    public boolean check(TreeNode node, int sum) {

        if(node == null)
            return false;

        if(check(node.left,sum) || check(node.right,sum)) {
            return true;
        }

        if(sum(node) == sum) {
            return true;
        }

        return false;
    }

    public int sum(TreeNode node) {

        if (node == null)
            return 0;

        return node.val + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(4);
        node1.right = new TreeNode(6);
        TreeNode node2 = new TreeNode(7);
        node2.left = new TreeNode(5);
        node2.right = new TreeNode(6);
        node.left = node1;
        node.right = node2;

        EqualTreePartition ets = new EqualTreePartition();
        System.out.println("Equal Tree Partition Possible -> " + ets.solve(node));
    }
}
