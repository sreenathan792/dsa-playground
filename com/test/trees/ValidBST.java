package com.test.trees;

/**
 * You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
 * <p>
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * 1) The left subtree of a node contains only nodes with keys less than the node's key.
 * <p>
 * 2) The right subtree of a node contains only nodes with keys greater than the node's key.
 * <p>
 * 3) Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Number of nodes in binary tree <= 105
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 0 <= node values <= 232-1
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is head of the binary tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 0 if false and 1 if true.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    3
 * Input 2:
 * <p>
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 2 is not less than 1 but is in left subtree of 1.
 * Explanation 2:
 * <p>
 * Satisfies all conditions.
 */
public class ValidBST {

    public int isValidBST(TreeNode A) {

        if(isBalanced(A)) {
            return 1;
        }

        return 0;
    }

    int prev = Integer.MIN_VALUE;
    private boolean isBalanced(TreeNode node) {

        if(node == null)
            return true;

        if(isBalanced(node.left) == false)
            return false;

        if(node.val < prev)
            return false;
        else
            prev = node.val;

        return isBalanced(node.right);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        ValidBST vBst = new ValidBST();
        System.out.println("Is Height Balanced Binary Tree -> " + vBst.isValidBST(node));
    }

}
