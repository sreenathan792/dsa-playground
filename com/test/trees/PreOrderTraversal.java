package com.test.trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a binary tree, return the preorder traversal of its nodes values.
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
 * Return an integer array denoting the preorder traversal of the given binary tree.
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
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 6, 2, 3]
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The Preoder Traversal of the given tree is [1, 2, 3].
 * Explanation 2:
 * <p>
 * The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
public class PreOrderTraversal {

    public int[] preorderTraversal(TreeNode A) {

        ArrayList<Integer> arr = new ArrayList<>();
        preorder(A, arr);

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public void preorder(TreeNode root, ArrayList<Integer> arr) {

        if (root == null)
            return;

        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(5);
        node.right = new TreeNode(7);

        PreOrderTraversal preorder = new PreOrderTraversal();
        System.out.println("Preorder Traversal of Tree -> " + Arrays.toString(preorder.preorderTraversal(node)));
    }
}
