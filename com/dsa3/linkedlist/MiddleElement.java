package com.dsa3.linkedlist;

/**
 * Given a linked list of integers, find and return the middle element of the linked list.
 * <p>
 * <p>
 * <p>
 * NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the linked list <= 100000
 * <p>
 * 1 <= Node value <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given head pointer of linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the middle element of the linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1 -> 2 -> 3 -> 4 -> 5
 * Input 2:
 * <p>
 * 1 -> 5 -> 6 -> 2 -> 3 -> 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 */
public class MiddleElement {

    public int solve(ListNode A) {

        ListNode curr = A;
        int count = 0;
        while(curr!= null) {
            count++;
            curr = curr.next;
        }

        int midCo = count/2;
        ListNode temp = A;
        for(int i = 0; i<midCo; i++) {
            temp = temp.next;
        }

        return temp.val;
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
        head.next.next.next.next.next = new ListNode(6);

        printList(head);

        MiddleElement mid = new MiddleElement();
        System.out.println("Middle Element of the Linked List -> "+ mid.solve(head));
    }
}
