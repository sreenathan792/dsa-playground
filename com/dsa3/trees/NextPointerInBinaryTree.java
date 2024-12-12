package com.dsa3.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree,
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Assume perfect binary tree.
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
 * Return the head of the binary tree after the changes are made.
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
 * Input 2:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    5
 * / \  / \
 * 3  4  6  7
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * Output 2:
 * <p>
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 5 -> NULL
 * / \  / \
 * 3->4->6->7 -> NULL
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Next pointers are set as given in the output.
 * Explanation 2:
 * <p>
 * Next pointers are set as given in the output.
 */
public class NextPointerInBinaryTree {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {

        ArrayDeque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeLinkNode last = root;
        while(!queue.isEmpty()) {
            TreeLinkNode x = queue.poll();
            if(x.left != null)
                queue.add(x.left);
            if(x.right != null)
                queue.add(x.right);

            if(x!=last) {
                x.next = queue.getFirst();
            } else {
                if(!queue.isEmpty())
                    last = queue.getLast();
            }
        }
    }

    public static void main(String[] args) {

        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.left.left = new TreeLinkNode(3);
        node.left.right = new TreeLinkNode(4);
        node.right = new TreeLinkNode(5);
        node.right.left = new TreeLinkNode(6);
        node.right.right = new TreeLinkNode(7);

        NextPointerInBinaryTree nxtptr = new NextPointerInBinaryTree();
        nxtptr.connect(node);
    }

}
