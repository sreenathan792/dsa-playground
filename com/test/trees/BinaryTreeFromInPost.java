package com.test.trees;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * <p>
 * <p>
 * NOTE: You may assume that duplicates do not exist in the tree.
 * <p>
 * <p>
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
 * First argument is an integer array A denoting the inorder traversal of the tree.
 * <p>
 * Second argument is an integer array B denoting the postorder traversal of the tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the root node of the binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [2, 1, 3]
 * B = [2, 3, 1]
 * Input 2:
 * <p>
 * A = [6, 1, 3, 2]
 * B = [6, 3, 2, 1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * / \
 * 2   3
 * Output 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Create the binary tree and return the root node of the tree.
 */
public class BinaryTreeFromInPost {

    HashMap<Integer, Integer> hmInorder = new HashMap<>();
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = A.size();
        for(int i = 0; i<n; i++) {
            hmInorder.put(A.get(i), i);
        }

        return build(A, 0, n-1, B, n-1);

    }

    private TreeNode build(ArrayList<Integer> inorder, int i, int j, ArrayList<Integer> postorder, int k) {

        if(i>j)
            return null;

        TreeNode root = new TreeNode(postorder.get(k));

        int inIndex = hmInorder.get(postorder.get(k));
        int sizeRightSubtree = j-inIndex;

        root.left = build(inorder, i, inIndex-1, postorder, k-1-sizeRightSubtree);
        root.right = build(inorder, inIndex+1, j, postorder, k-1);

        return root;
    }

    public static void main(String[] args) {

        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder.add(6);
        inOrder.add(1);
        inOrder.add(3);
        inOrder.add(2);
        ArrayList<Integer> postOrder = new ArrayList<>();
        inOrder.add(6);
        inOrder.add(3);
        inOrder.add(2);
        inOrder.add(1);
        BinaryTreeFromInPost bInPo = new BinaryTreeFromInPost();
        System.out.println("Binary Tree -> " + bInPo.buildTree(inOrder,postOrder));
    }
}
