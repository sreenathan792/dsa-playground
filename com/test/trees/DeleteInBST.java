package com.test.trees;

/**
 * Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
 *
 * Note - If there are multiple options, always replace a node by its in-order predecessor
 *
 *
 * Problem Constraints
 *
 * 2 <= No. of nodes in BST <= 105
 * 1 <= value of nodes <= 109
 * Each node has a unique value
 *
 *
 * Input Format
 *
 * The first argument is the root node of a Binary Search Tree A.
 * The second argument is the value B.
 *
 *
 * Output Format
 *
 * Delete the given node if found and return the root of the BST.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *             15
 *           /    \
 *         12      20
 *         / \    /  \
 *        10  14  16  27
 *       /
 *      8
 *
 *      B = 10
 *
 * Input 2:
 *
 *             8
 *            / \
 *           6  21
 *          / \
 *         1   7
 *
 *      B = 6
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *             15
 *           /    \
 *         12      20
 *         / \    /  \
 *        8  14  16  27
 *
 * Output 2:
 *
 *             8
 *            / \
 *           1  21
 *            \
 *             7
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Node with value 10 is deleted
 * Explanation 2:
 *
 * Node with value 6 is deleted
 */
public class DeleteInBST {

    public TreeNode solve(TreeNode A, int B) {

        if(A == null)
            return null;

        if(B<A.val) {
            A.left = solve(A.left,B);
        } else if (B>A.val) {
            A.right = solve(A.right, B);
        } else {

            if(A.left == null && A.right == null) {
                return null;
            } else if (A.left == null || A.right == null) {

                if(A.left != null)
                    return A.left;
                else
                    return A.right;
            } else {

                TreeNode leftSub = A.left;
                while(leftSub.right != null) {
                    leftSub = leftSub.right;
                }

                A.val = leftSub.val;
                A.left = solve(A.left, leftSub.val);
            }
        }

        return A;
    }

    public static void main(String[] args) {

        /*TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);*/

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(7);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(5);
        node.right.left.left = new TreeNode(4);
        node.right.left.right = new TreeNode(6);

        DeleteInBST delBST = new DeleteInBST();
        System.out.println("Tree After Deletion -> " + delBST.solve(node, 3));
    }
}
