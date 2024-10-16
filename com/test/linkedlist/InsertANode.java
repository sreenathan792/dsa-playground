package com.test.linkedlist;

/**
 * You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.
 * <p>
 * Notes:
 * <p>
 * In case the position is more than length of linked list, simply insert the new node at the tail only.
 * In case the pos is 0, simply insert the new node at head only.
 * Follow 0-based indexing for the node numbering.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= size of linked list <= 105
 * <p>
 * 1 <= value of nodes <= 109
 * <p>
 * 1 <= B <= 109
 * <p>
 * 0 <= C <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument A is the head of a linked list.
 * <p>
 * The second argument B is an integer which denotes the value of the new node
 * <p>
 * The third argument C is an integer which denotes the position of the new node
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the head of the linked list
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = 1 -> 2
 * B = 3
 * C = 0
 * Input 2:
 * A = 1 -> 2
 * B = 3
 * C = 1
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * 3 -> 1 -> 2
 * Output 2:
 * 1 -> 3 -> 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * For Input 1:
 * The new node is add to the head of the linked list
 * For Input 2:
 * The new node is added after the first node of the linked list
 */

public class InsertANode {

    public ListNode solve(ListNode A, int B, int C) {

        ListNode newNode = new ListNode(B);
        if (A == null) {
            return newNode;
        }

        if (C == 0) {
            newNode.next = A;
            A = newNode;
        } else {
            ListNode temp = A;
            for (int i = 0; i < C - 1; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                }
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        return A;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create the linked list 2->3->4->5
        //ListNode head = new ListNode(2);
        //head.next = new ListNode(3);
        //head.next.next = new ListNode(4);
        //head.next.next.next = new ListNode(5);

        ListNode head = new ListNode(7);

        printList(head);

        int data = 5;
        int position = 7;
        InsertANode insert = new InsertANode();
        head = insert.solve(head, data, position);

        printList(head);
    }
}
