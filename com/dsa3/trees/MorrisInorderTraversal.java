package com.dsa3.trees;

import java.util.ArrayList;

public class MorrisInorderTraversal {

    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> inorder = new ArrayList<>();
        TreeNode curr = A;
        while(curr != null) {

            if(curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {

                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if(pred.right == null) {
                    pred.right = curr; //creating link
                    curr = curr.left;
                } else {
                    pred.right = null; // breaking link
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        MorrisInorderTraversal morris = new MorrisInorderTraversal();
        System.out.println("Inorder -> " + morris.solve(node).toString());
    }
}
