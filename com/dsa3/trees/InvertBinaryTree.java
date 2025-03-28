package com.dsa3.trees;

/**
 * Given a binary tree A, invert the binary tree and return it.
 *
 * Inverting refers to making the left child the right child and vice versa.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= size of tree <= 100000
 *
 *
 *
 * Input Format
 *
 * First and only argument is the head of the tree A.
 *
 *
 *
 * Output Format
 *
 * Return the head of the inverted tree.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *
 *      1
 *    /   \
 *   2     3
 * Input 2:
 *
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *
 *      1
 *    /   \
 *   3     2
 * Output 2:
 *
 *
 *      1
 *    /   \
 *   3     2
 *  / \   / \
 * 7   6 5   4
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Tree has been inverted.
 * Explanation 2:
 *
 * Tree has been inverted
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode A) {

        if(A==null)
            return null;

        TreeNode invertedLeft = invertTree(A.left);
        TreeNode invertedRight = invertTree(A.right);

        A.left = invertedRight;
        A.right = invertedLeft;

        return A;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);

        InvertBinaryTree invert = new InvertBinaryTree();
        System.out.println("Inverted Binary Tree -> " + invert.invertTree(node));
    }

}
