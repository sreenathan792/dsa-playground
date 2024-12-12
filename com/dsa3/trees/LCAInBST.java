package com.dsa3.trees;

/**
 * Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.
 * <p>
 * <p>
 * Note 1 :- It is guaranteed that the nodes B and C exist.
 * <p>
 * Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Number of nodes in binary tree <= 105
 * <p>
 * 1 <= B , C <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is a root node of the binary tree, A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * Third argument is an integer C.
 * <p>
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the LCA of the two nodes
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
 * B = 8
 * C = 20
 * Input 2:
 * <p>
 * 8
 * / \
 * 6  21
 * / \
 * 1   7
 * <p>
 * B = 7
 * C = 1
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 15
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The LCA of node 8 and 20 is the node 15.
 * Explanation 2:
 * <p>
 * The LCA of node 7 and 1 is the node 6.
 */
public class LCAInBST {

    public int solve(TreeNode A, int B, int C) {

        TreeNode lca = findLCA(A, B, C);
        if (null == lca)
            return -1;

        return lca.val;
    }

    private TreeNode findLCA(TreeNode node, int B, int C) {

        TreeNode curr = node;
        while (curr != null) {

            if (B < curr.val && C < curr.val) {
                curr = curr.left;
            } else if (B > curr.val && C > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(15);
        node.left = new TreeNode(12);
        node.right = new TreeNode(20);
        node.left.left = new TreeNode(10);
        node.left.right = new TreeNode(14);
        node.left.left.left = new TreeNode(8);
        node.right.left = new TreeNode(16);
        node.right.right = new TreeNode(27);

        LCAInBST lca = new LCAInBST();
        System.out.println("LCA ofNodes -> " + lca.solve(node, 8, 14));
    }
}
