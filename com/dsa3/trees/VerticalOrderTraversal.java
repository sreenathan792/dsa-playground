package com.dsa3.trees;

import java.util.*;

/**
 * Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
 * <p>
 * <p>
 * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only arument is a pointer to the root node of binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a 2D array denoting the vertical order traversal of tree as shown.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 6
 * /   \
 * 3     7
 * / \     \
 * 2   5     9
 * Input 2:
 * <p>
 * 1
 * /   \
 * 3      7
 * /       \
 * 2         9
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [
 * [2],
 * [3],
 * [6, 5],
 * [7],
 * [9]
 * ]
 * Output 2:
 * <p>
 * [
 * [2],
 * [3],
 * [1],
 * [7],
 * [9]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * First row represent the verical line 1 and so on.
 */
public class VerticalOrderTraversal {

    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));

        while (!queue.isEmpty()){
            Pair x = queue.poll();
            TreeNode temp = x.node;
            int dist = x.hd;

            if(hm.containsKey(dist)) {
                ArrayList<Integer> list = hm.get(dist);
                list.add(temp.val);
                hm.put(dist, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.val);
                hm.put(dist, list);
            }

            if(temp.left!=null) {
                queue.add(new Pair(temp.left, dist-1));
            }

            if(temp.right!=null) {
                queue.add(new Pair(temp.right, dist+1));
            }
        }

        ArrayList<ArrayList<Integer>> resArr = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> ent : hm.entrySet()) {
            resArr.add(ent.getValue());
        }

        return resArr;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(9);

        VerticalOrderTraversal ver = new VerticalOrderTraversal();
        System.out.println("Vertical Order Traversal -> " + ver.verticalOrderTraversal(node));
    }
}
