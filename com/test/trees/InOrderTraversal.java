package com.test.trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Return an integer array denoting the inorder traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
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
 * [1, 3, 2]
 * Output 2:
 * <p>
 * [6, 1, 3, 2]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The Inorder Traversal of the given tree is [1, 3, 2].
 * Explanation 2:
 * <p>
 * The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
public class InOrderTraversal {

    public int[] inorderTraversal(TreeNode A) {

        ArrayList<Integer> arr = new ArrayList<>();
        inorder(A, arr);

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public void inorder(TreeNode root, ArrayList<Integer> arr) {

        if(root == null)
            return;

        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(5);
        node.right = new TreeNode(7);

        InOrderTraversal inorder = new InOrderTraversal();
        System.out.println("Inorder Traversal of Tree -> " + Arrays.toString(inorder.inorderTraversal(node)));

    }
}
