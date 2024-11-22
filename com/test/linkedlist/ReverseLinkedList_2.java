package com.test.linkedlist;

/**
 * Reverse a linked list A from position B to C.
 * <p>
 * NOTE: Do it in-place and in one-pass.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 106
 * <p>
 * 1 <= B <= C <= |A|
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument contains a pointer to the head of the given linked list, A.
 * <p>
 * The second arugment contains an integer, B.
 * <p>
 * The third argument contains an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a pointer to the head of the modified linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 1 -> 2 -> 3 -> 4 -> 5
 * B = 2
 * C = 4
 * <p>
 * Input 2:
 * <p>
 * A = 1 -> 2 -> 3 -> 4 -> 5
 * B = 1
 * C = 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1 -> 4 -> 3 -> 2 -> 5
 * Output 2:
 * <p>
 * 5 -> 4 -> 3 -> 2 -> 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
 * Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
 * Explanation 2:
 * <p>
 * In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
 * Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
 */
public class ReverseLinkedList_2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // Handle edge cases
        if (head == null || m == n) {
            return head;
        }

        // Step 1: Find the node before the start of the reversal range
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the nodes within the range
        ListNode tail = prev.next;
        ListNode next = null;
        for (int i = 0; i < n - m; i++) {
            next = tail.next;
            tail.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        printList(next);

        // Step 3: Connect the reversed portion with the rest of the list
        return dummy.next;

    }

    private void reverse(ListNode from) {

        ListNode prev = null;
        ListNode head = from;
        while(head!= null) {
            ListNode next = head.next;
            head.next = prev;
            prev = next;
            head = next;
        }
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

        // Create the linked list 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);

        ReverseLinkedList_2 reverse = new ReverseLinkedList_2();
        head = reverse.reverseBetween(head, 2, 4);

        printList(head);
    }

}
