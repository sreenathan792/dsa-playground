package com.dsa3.trees;

/**
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 * <p>
 * <p>
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= size of tree <= 100000
 * <p>
 * 1 <= B, C <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is head of tree A.
 * <p>
 * Second argument is integer B.
 * <p>
 * Third argument is integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the LCA.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    3
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * 1
 * /  \
 * 2    3
 * / \
 * 4   5
 * B = 4
 * C = 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * LCA is 1.
 * Explanation 2:
 * <p>
 * LCA is 2.
 */
public class LowestCommonAncestor {

    boolean b1 = false;
    boolean c1 = false;
    public int lca(TreeNode A, int B, int C) {

        TreeNode lca = findLCA(A, B, C);
        if(null == lca || !(b1 && c1))
            return -1;

        return lca.val;
    }

    private TreeNode findLCA(TreeNode root, int B, int C) {

        if(root == null) {
            return null;
        }

        TreeNode temp = null;

        if(root.val == B) {
            b1 = true;
            temp = root;
        }

        if(root.val == C) {
            c1 = true;
            temp = root;
        }

        TreeNode leftLCA = findLCA(root.left, B, C);
        TreeNode rightLCA = findLCA(root.right, B, C);

        if(temp != null) {
            return temp;
        }

        if(leftLCA != null && rightLCA != null) {
            return root;
        }

        if(leftLCA != null) {
            return leftLCA;
        } else{
            return rightLCA;
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node4.right = node7;
        node2.right = node5;
        node1.right = node3;

        LowestCommonAncestor lca = new LowestCommonAncestor();
        System.out.println("LCA ofNodes -> " + lca.lca(node1, 6, 8));
    }

}
