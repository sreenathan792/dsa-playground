package com.test.trees;

/**
 * Given a root of binary tree A, determine if it is height-balanced.
 * <p>
 * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= size of tree <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is the root of the tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1
 * / \
 * 2   3
 * Input 2:
 * <p>
 * <p>
 * 1
 * /
 * 2
 * /
 * 3
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
 * It is a complete binary tree.
 * Explanation 2:
 * <p>
 * Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 * Difference = 2 > 1.
 */
public class BalancedBinaryTree {

    public int isBalanced(TreeNode A) {

        if(checkBalanced(A))
            return 1;

        return 0;
    }

    private boolean checkBalanced(TreeNode node) {

        if(node == null)
            return true;

        int lh = height(node.left);
        int rh = height(node.right);

        if(Math.abs(lh-rh)>1)
            return false;

        return checkBalanced(node.left) && checkBalanced(node.right);
    }

    private int height(TreeNode node) {

        if(node == null)
            return -1;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);

        BalancedBinaryTree bb = new BalancedBinaryTree();
        System.out.println("Is Height Balanced Binary Tree -> " + bb.isBalanced(node));
    }
}
