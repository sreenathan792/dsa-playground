package com.test.linkedlist;

/**
 * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the given linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 0, if the linked list is not a palindrome.
 * <p>
 * Return 1, if the linked list is a palindrome.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 2, 1]
 * Input 2:
 * <p>
 * A = [1, 3, 2]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
 * Explanation 2:
 * <p>
 * The second linked list is not a palindrome as [1, 3, 2] is not equal to [2, 3, 1].
 */
public class PalindromeLinkedList {

    public int lPalin(ListNode A) {

        //create a deep copy of the given LL
        ListNode head = A;
        ListNode head1 = new ListNode(head.val);
        ListNode temp = head;
        ListNode temp1 = head1;
        while(temp.next!= null) {
            temp1.next = new ListNode(temp.next.val);
            temp = temp.next;
            temp1 = temp1.next;
        }

        printList(head);
        printList(head1);

        //reverse the new LL
        head1 = reverse(head1);

        //traverse and check if the old and new LLs match
        while(head != null) {

            if(head.val != head1.val) {

                return 0;
            }

            head = head.next;
            head1 = head1.next;
        }

        return 1;
    }

    public ListNode reverse(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;
        while(temp!= null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
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

        // Create the linked list 1->2->1->2->1
        /*ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);*/

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        printList(head);

        PalindromeLinkedList palin = new PalindromeLinkedList();
        System.out.println("Is Palindrome->" + palin.lPalin(head));
    }
}
