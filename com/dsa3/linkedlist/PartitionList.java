package com.dsa3.linkedlist;

/**
 * Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |A| <= 106
 * <p>
 * 1 <= A[i], B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument of input contains a pointer to the head to the given linked list.
 * <p>
 * The second argument of input contains an integer, B.
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
 * A = [1, 4, 3, 2, 5, 2]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2, 3, 1, 3]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [1, 2, 2, 4, 3, 5]
 * Output 2:
 * <p>
 * [1, 1, 2, 3, 3]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
 * Explanation 2:
 * <p>
 * [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.
 */
public class PartitionList {

    public ListNode partition(ListNode A, int B) {

        ListNode lessHead = new ListNode(0);
        ListNode greatHead = new ListNode(0);

        ListNode curr = A;
        ListNode less = lessHead;
        ListNode great = greatHead;
        while(curr != null) {

            if(curr.val < B) {
                less.next = curr;
                less = less.next;
            } else {
                great.next = curr;
                great = great.next;
            }
            curr = curr.next;
        }

        great.next = null;
        less.next = greatHead.next;

        return lessHead.next;
    }

    public static void main(String[] args) {

        // Create the linked list 1 -> 4 -> 3 -> 2 ->  5 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        printList(head);

        PartitionList part = new PartitionList();
        System.out.println("Modified List -> ");

        printList(part.partition(head, 3));
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
