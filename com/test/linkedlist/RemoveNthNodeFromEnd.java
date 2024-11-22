package com.test.linkedlist;

/**
 *
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode head = A;
        int size = 0;
        while(head!= null) {
            size++;
            head = head.next;
        }

        if(B>=size) {
            return A.next;
        } else {

            ListNode tempNode = A;
            for(int i = 0; i<size-B-1; i++){
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;
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

        // Create the linked list 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);

        RemoveNthNodeFromEnd remove = new RemoveNthNodeFromEnd();
        head = remove.removeNthFromEnd(head, 2);

        printList(head);
    }
}
