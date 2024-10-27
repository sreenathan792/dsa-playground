package com.test.trees;

import java.util.Arrays;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= number of nodes <= 105
 * <p>
 * -100000 <= B, value of nodes <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is a root node of the binary tree, A.
 * <p>
 * Second argument is an integer B denoting the sum.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * Tree:    5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * <p>
 * B = 22
 * Input 2:
 * <p>
 * Tree:    5
 * / \
 * 4   8
 * /   / \
 * -11 -13  4
 * <p>
 * B = -1
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
 * There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
 * Explanation 2:
 * <p>
 * There is no path which has sum -1.
 */
public class PathSum {

    public int hasPathSum(TreeNode A, int B) {

        if(hasPath(A,B))
            return 1;

        return 0;
    }

    public boolean hasPath(TreeNode node, int sum) {

        if (node == null)
            return false;

        sum -= node.val;

        if (node.left == null && node.right == null) {
            return (sum == 0);
        }

        return (hasPath(node.left, sum) || hasPath(node.right, sum));
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(11);
        node1.left.left = new TreeNode(7);
        node1.left.right = new TreeNode(2);

        TreeNode node2 = new TreeNode(8);
        node2.left = new TreeNode(13);
        node2.right = new TreeNode(4);
        node2.right.right = new TreeNode(1);

        node.left = node1;
        node.right = node2;

        PathSum ps = new PathSum();
        System.out.println("Path Sum of Tree Possible -> " + ps.hasPathSum(node, 22));
    }
}
