package com.test.linkedlist;

/**
 * You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
 * <p>
 * Note : Follow 0-based indexing for the node numbering.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= size of linked list <= 105
 * 1 <= value of nodes <= 109
 * 0 <= B < size of linked list
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument A is the head of a linked list.
 * <p>
 * The second arguement B is an integer.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the head of the linked list after deletion
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * A = 1 -> 2 -> 3
 * B = 1
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
 * B = 0
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * 1 -> 3
 * Output 2:
 * 3 -> 2 -> 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * For Input 1:
 * The linked list after deletion is 1 -> 3.
 * For Input 2:
 * The linked list after deletion is 3 -> 2 -> 1.
 */
public class DeleteLinkedList {

    public ListNode solve(ListNode A, int B) {

        // If we are to remove the head node
        if (B == 0) {
            return A != null ? A.next : null; // Return the new head
        }

        ListNode curr = A;
        int ind = 0; // Start indexing from 0 since the head node is B=0
        ListNode prev = null; // To keep track of the previous node

        while (curr != null) {
            if (ind == B) {
                if (prev != null) {
                    prev.next = curr.next; // Skip the current node
                }
                break; // Node has been removed
            }
            prev = curr; // Move prev to curr
            curr = curr.next; // Move curr to the next node
            ind++;
        }

        return A; // Return the modified head
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
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);

        //ListNode head = new ListNode(7);

        printList(head);

        int position = 0;
        DeleteLinkedList delete = new DeleteLinkedList();
        head = delete.solve(head, position);

        printList(head);
    }
}
