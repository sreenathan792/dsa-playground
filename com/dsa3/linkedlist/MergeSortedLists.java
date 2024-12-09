package com.dsa3.linkedlist;

/**
 * Merge two sorted linked lists, A and B, and return it as a new list.
 * <p>
 * <p>
 * <p>
 * <p>
 * The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= |A|, |B| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument of input contains a pointer to the head of linked list A.
 * <p>
 * The second argument of input contains a pointer to the head of linked list B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a pointer to the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 5 -> 8 -> 20
 * B = 4 -> 11 -> 15
 * Input 2:
 * <p>
 * A = 1 -> 2 -> 3
 * B = Null
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Output 2:
 * <p>
 * 1 -> 2 -> 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Explanation 2:
 * <p>
 * We don't need to merge as B is empty.
 */
public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }

        ListNode head = null;
        if (A.val <= B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        ListNode curr = head;
        while (A != null && B != null) {

            if (A.val <= B.val) {
                curr.next = A;
                A = A.next;
            } else {
                curr.next = B;
                B = B.next;
            }
            curr = curr.next;
        }

        if (A == null) {
            curr.next = B;
        } else {
            curr.next = A;
        }

        return head;
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

        // Create the linked list 5->8->20
        ListNode head = new ListNode(5);
        head.next = new ListNode(8);
        head.next.next = new ListNode(20);

        printList(head);

        // Create the linked list 4->11->15
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(11);
        head1.next.next = new ListNode(15);

        printList(head1);

        MergeSortedLists merge = new MergeSortedLists();
        ListNode merged = merge.mergeTwoLists(head, head1);

        printList(merged);
    }
}
