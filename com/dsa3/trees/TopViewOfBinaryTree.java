package com.dsa3.trees;

import java.util.*;

/**
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
 * <p>
 * Return the nodes in any order.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is head of the binary tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an array, representing the top view of the binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * 1
 * /   \
 * 2    3
 * / \  / \
 * 4   5 6  7
 * /
 * 8
 * Input 2:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    3
 * \
 * 4
 * \
 * 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 2, 4, 8, 3, 7]
 * Output 2:
 * <p>
 * [1, 2, 3]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Top view is described.
 * Explanation 2:
 * <p>
 * Top view is described.
 */
public class TopViewOfBinaryTree {

    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {

        TreeMap<Integer, Integer> hm = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));

        while (!queue.isEmpty()){
            Pair x = queue.poll();
            TreeNode temp = x.node;
            int dist = x.hd;

            if(!hm.containsKey(dist)) {
                hm.put(dist, temp.val);
            }

            if(temp.left!=null) {
                queue.add(new Pair(temp.left, dist-1));
            }

            if(temp.right!=null) {
                queue.add(new Pair(temp.right, dist+1));
            }
        }

        ArrayList<Integer> resArr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> ent : hm.entrySet()) {
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

        TopViewOfBinaryTree top = new TopViewOfBinaryTree();
        System.out.println("Top View of Binary Tree -> " + top.solve(node));
    }
}
