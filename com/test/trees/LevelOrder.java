package com.test.trees;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is root node of the binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a 2D integer array denoting the level order traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Input 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [
 * [3],
 * [9, 20],
 * [15, 7]
 * ]
 * Output 2:
 * <p>
 * [
 * [1]
 * [6, 2]
 * [3]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int n = queue.size(); // no of nodes at each level
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.left.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        LevelOrder lo = new LevelOrder();
        System.out.println("Level Order Traversal of Tree -> " + lo.solve(node).toString());
    }

}
