package com.dsa3.linkedlist;

/**
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 * <p>
 * Pointer to next node in the main list (right pointer)
 * Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
 * You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Total nodes in the list <= 100000
 * <p>
 * 1 <= Value of node <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is head pointer of the doubly linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the head pointer of the Flattened list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 3 -> 4 -> 20 -> 20 ->30
 * |    |    |     |    |
 * 7    11   22    20   31
 * |               |    |
 * 7               28   39
 * |               |
 * 8               39
 * Input 2:
 * <p>
 * 2 -> 4
 * |    |
 * 7    11
 * |
 * 7
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39
 * Output 2:
 * <p>
 * 2 -> 4 -> 7 -> 7 -> 11
 */
public class FlattenLinkedList {

    static class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    ListNode flatten(ListNode root) {

        if(root == null || root.right == null)
            return root;

        ListNode mid = findMiddle(root);
        ListNode midNext = mid.right;
        mid.right = null;

        ListNode left = flatten(root);
        ListNode right = flatten(midNext);

        return merge(left, right);

    }

    public ListNode merge(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode result;
        if (head1.val <= head2.val) {
            result = head1;
            result.down = merge(head1.down, head2);
        } else {
            result = head2;
            result.down = merge(head1, head2.down);
        }

        return result;
    }

    private ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        if(head == null) {
            return head;
        }

        while(fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }

        return slow;
    }

    public static void main(String[] args) {

        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n7 = new ListNode(7);
        ListNode n71 = new ListNode(7);
        ListNode n11 = new ListNode(11);
        n2.right = n4;
        n4.down = n11;
        n2.down = n7;
        n7.down = n71;

        FlattenLinkedList flatten = new FlattenLinkedList();
        ListNode flattened = flatten.flatten(n2);

        printList(flattened);
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.down;
        }
        System.out.println();
    }
}
