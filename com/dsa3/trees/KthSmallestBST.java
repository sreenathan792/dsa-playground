package com.dsa3.trees;

import com.test.trees.BalancedBinaryTree;

/**
 * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 10^9
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
 * Return an integer, representing the Bth element.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * 2
 * /   \
 * 1    3
 * B = 2
 * Input 2:
 * <p>
 * <p>
 * 3
 * /
 * 2
 * /
 * 1
 * B = 1
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 2nd element is 2.
 * Explanation 2:
 * <p>
 * 1st element is 1.
 */
public class KthSmallestBST {

    int count = 0;
    int ans = Integer.MIN_VALUE;
    public int kthsmallest(TreeNode A, int B) {

        inorder(A,B);
        return ans;
    }

    private void inorder(TreeNode node, int k) {

        if(node == null)
            return;

        inorder(node.left, k);
        count++;

        if(count == k) {

            ans = node.val;
            return;
        }

        if(ans == Integer.MIN_VALUE) {
            inorder(node.right, k);
        }
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        KthSmallestBST kth = new KthSmallestBST();
        System.out.println("Element in BST -> " + kth.kthsmallest(node, 2));
    }
}
