package com.dsa3.trees;

/**
 * Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
 * <p>
 * The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= N <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only Argument represents the root of binary tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an single integer denoting the diameter of the tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \
 * 4   5
 * Input 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \     \
 * 4   5     6
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
 * Explanation 2:
 * <p>
 * Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */
public class DiameterOfBinaryTree {

    public int solve(TreeNode A) {

        if(A == null) {
            return 0;
        }

        int heightLeft = height(A.left);
        int heightRight = height(A.right);

        int leftDiameter = solve(A.left);
        int rightDiameter = solve(A.right);

        return Math.max(heightLeft+heightRight,Math.max(leftDiameter,rightDiameter));

    }

    public int height(TreeNode node) {
        if(node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);

        DiameterOfBinaryTree dia = new DiameterOfBinaryTree();
        System.out.println("Diameter of BT -> " + dia.solve(node));
    }
}
