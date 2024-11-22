package com.test.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class LeftViewOfBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(A);


        while (!queue.isEmpty()) {

            TreeNode node = queue.peek();
            res.add(node.val);
            int n = queue.size(); // no of nodes at each level
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }

            }
        }

        return res;

    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.right.right.right = new TreeNode(8);

        LeftViewOfBinaryTree lv = new LeftViewOfBinaryTree();
        System.out.println("Right View of Binary Tree -> " + lv.solve(node).toString());
    }
}