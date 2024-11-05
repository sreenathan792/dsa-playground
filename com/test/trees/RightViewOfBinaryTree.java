package com.test.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
/**
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
 * <p>
 * Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
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
 * Return an array, representing the right view of the binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * 1
 * /   \
 * 2    3
 * / \  / \
 * 4   5 6  7
 * /
 * 8
 * Input 2:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    3
 * \
 * 4
 * \
 * 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 3, 7, 8]
 * Output 2:
 * <p>
 * [1, 3, 4, 5]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Right view is described.
 * Explanation 2:
 * <p>
 * Right view is described.
 */
public class RightViewOfBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(A);
        TreeNode last = A;

        while (!queue.isEmpty()) {

            int n = queue.size(); // no of nodes at each level
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }

                if(temp == last) {
                    res.add(temp.val);
                    if(!queue.isEmpty())
                        last = queue.getLast();
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(8);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        RightViewOfBinaryTree rv = new RightViewOfBinaryTree();
        System.out.println("Right View of Binary Tree -> " + rv.solve(node).toString());
    }

}
