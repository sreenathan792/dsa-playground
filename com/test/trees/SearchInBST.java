package com.test.trees;

/**
 * Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Number of nodes in binary tree <= 105
 * <p>
 * 0 <= B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is a root node of the binary tree, A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return 1 if such a node exist and 0 otherwise
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 15
 * /    \
 * 12      20
 * / \    /  \
 * 10  14  16  27
 * /
 * 8
 * <p>
 * B = 16
 * Input 2:
 * <p>
 * 8
 * / \
 * 6  21
 * / \
 * 1   7
 * <p>
 * B = 9
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
 * Node with value 16 is present.
 * Explanation 2:
 * <p>
 * There is no node with value 9.
 */
public class SearchInBST {

    public int solve(TreeNode A, int B) {

        boolean search = checkInBst(A, B);
        if (search)
            return 1;

        return 0;
    }

    private boolean checkInBst(TreeNode node, int b) {

        if (node == null)
            return false;

        if (node.val == b) {
            return true;
        }

        if (b < node.val) {
            return checkInBst(node.left, b);
        }

        return checkInBst(node.right, b);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(15);
        node.left = new TreeNode(12);
        node.left.left = new TreeNode(10);
        node.left.right = new TreeNode(14);
        node.left.left.left = new TreeNode(8);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(16);
        node.right.right = new TreeNode(27);

        SearchInBST bst = new SearchInBST();
        System.out.println("Is Element present in Binary Search Tree -> " + bst.solve(node, 16));
    }
}
