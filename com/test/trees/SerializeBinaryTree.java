package com.test.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
 * <p>
 * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
 * <p>
 * NOTE:
 * <p>
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
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
 * Only argument is a A denoting the root node of a Binary Tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer array denoting the Level Order Traversal of the given Binary Tree.
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
 * <p>
 * Input 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \     \
 * 4   5     6
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * <p>
 * Output 2:
 * <p>
 * [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 * Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * <p>
 * Explanation 2:
 * <p>
 * The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 * Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class SerializeBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                TreeNode tempNode = queue.poll();

                if (tempNode == null) {
                    res.add(-1);
                } else {
                    res.add(tempNode.val);

                    if (tempNode.left == null) {
                        queue.offer(null);
                    } else {
                        queue.offer(tempNode.left);
                    }

                    if (tempNode.right == null) {
                        queue.offer(null);
                    } else {
                        queue.offer(tempNode.right);
                    }
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
        node.right.right = new TreeNode(6);

        SerializeBinaryTree ser = new SerializeBinaryTree();
        System.out.println("Level Order Traversal of Tree -> " + ser.solve(node));
    }

}
