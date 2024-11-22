package com.test.trees;

import java.util.*;

/**
 * You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
 * <p>
 * NOTE:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= number of nodes <= 105
 * <p>
 * -1 <= A[i] <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the root node of the Binary Tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \
 * 4   5
 * Output 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \ .   \
 * 4   5 .   6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 * Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 * <p>
 * Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 * Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */

public class DeSerializeBinaryTree {


    public TreeNode solve(ArrayList<Integer> A) {

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(A.get(0));
        queue.offer(root);
        int i = 1;

        while(!queue.isEmpty()) {

            TreeNode currNode = queue.poll();
            if(currNode == null)
                continue;

            if(i+1 < A.size()) {

                int left = A.get(i);
                int right = A.get(i+1);
                i += 2;

                if(left == -1) {
                    currNode.left = null;
                } else {
                    currNode.left = new TreeNode(left);
                }

                if(right == -1) {
                    currNode.right = null;
                } else {
                    currNode.right = new TreeNode(right);
                }

                queue.offer(currNode.left);
                queue.offer(currNode.right);

            }

        }

         return root;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(List.of(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));

        DeSerializeBinaryTree dSer = new DeSerializeBinaryTree();
        System.out.println("Binary Tree -> " + dSer.solve(arr));
    }

}
