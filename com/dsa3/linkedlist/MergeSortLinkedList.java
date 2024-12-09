package com.dsa3.linkedlist;

/**
 * Sort a linked list, A in O(n log n) time.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= |A| = 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and the only arugment of input contains a pointer to the head of the linked list, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a pointer to the head of the sorted linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [3, 4, 2, 8]
 * Input 2:
 * <p>
 * A = [1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [2, 3, 4, 8]
 * Output 2:
 * <p>
 * [1]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
 * Explanation 2:
 * <p>
 * The sorted form of [1] is [1].
 */
public class MergeSortLinkedList {

    public ListNode sortList(ListNode A) {

        if(A == null || A.next == null)
            return A;

        ListNode midNode = findMiddle(A);

        ListNode head1 = A;
        ListNode head2 = midNode.next;
        midNode.next = null;

        head1 = sortList(head1);
        head2 = sortList(head2);

        return merge(head1, head2);
    }

    public static void main(String[] args) {

        // Create the linked list 3->4->2->8
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(8);

        printList(head);

        MergeSortLinkedList sort = new MergeSortLinkedList();
        ListNode sorted = sort.sortList(head);

        printList(sorted);
    }

    public ListNode merge(ListNode head1, ListNode head2) {

        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        ListNode head = null;
        if(head1.val <= head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        ListNode curr = head;
        while(head1!= null && head2 != null) {

            if(head1.val<= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }

            curr = curr.next;
        }

        if(head1 == null) {
            curr.next = head2;
        } else {
            curr.next = head1;
        }

        return head;
    }

    public ListNode findMiddle (ListNode head) {

        if(head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }
}
