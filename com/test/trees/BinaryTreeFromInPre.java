package com.test.trees;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A denoting the preorder traversal of the tree.
 *
 * Second argument is an integer array B denoting the inorder traversal of the tree.
 *
 *
 *
 * Output Format
 *
 * Return the root node of the binary tree.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3]
 *  B = [2, 1, 3]
 * Input 2:
 *
 *  A = [1, 6, 2, 3]
 *  B = [6, 1, 3, 2]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *    1
 *   / \
 *  2   3
 * Output 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Create the binary tree and return the root node of the tree.
 */
public class BinaryTreeFromInPre {

    HashMap<Integer, Integer> hmInOrder = new HashMap<>();
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = B.size();
        for(int i = 0; i<n; i++) {
            hmInOrder.put(B.get(i), i);
        }

        return build(B, 0, n-1, A, 0);

    }

    private TreeNode build(ArrayList<Integer> inOrder, int i, int j, ArrayList<Integer> preOrder, int k) {

        if(i>j)
            return null;

        TreeNode root = new TreeNode(preOrder.get(k));
        int inIndex = hmInOrder.get(preOrder.get(k));

        // Calculate the size of the left subtree
        int leftSubtreeSize = inIndex - i;

        root.left = build(inOrder, i, inIndex-1, preOrder, k+1);
        root.right = build(inOrder, inIndex+1, j, preOrder, k+leftSubtreeSize+1);

        return root;
    }


    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrder.add(1);
        preOrder.add(6);
        preOrder.add(2);
        preOrder.add(3);

        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder.add(6);
        inOrder.add(1);
        inOrder.add(3);
        inOrder.add(2);

        BinaryTreeFromInPre bInPre = new BinaryTreeFromInPre();
        System.out.println("Binary Tree -> " + bInPre.buildTree(inOrder,preOrder));
    }
}
