package com.dsa3.linkedlist;

/**
 * Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
 * <p>
 * A palindrome list is a list that reads the same backward and forward.
 * <p>
 * Expected memory complexity : O(1)
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the linked list <= 2000
 * <p>
 * 1 <= Node value <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is head pointer of the linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the length of the longest palindrome list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 2 -> 3 -> 3 -> 3
 * Input 2:
 * <p>
 * 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 3 -> 3 -> 3 is largest palindromic sublist
 * Explanation 2:
 * <p>
 * 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
 */
public class LongestPalindromicList {

    public int solve(ListNode A) {

        int result = 0;

        ListNode curr = A;
        ListNode prev = null;
        while(curr != null) {

            ListNode fwd = curr.next;
            curr.next = prev;

            //odd-list
            result = Math.max(result, 2 * countMatching(prev, fwd)+1 );

            //even-list
            result = Math.max(result, 2 * countMatching(curr, fwd));

            prev = curr;
            curr = fwd;
        }

        return result;
    }

    public int countMatching(ListNode head1, ListNode head2) {

        int count = 0;
        while(head1 != null && head2 != null) {

            if(head1.val == head2.val)
                count++;
            else
                break;

            head1 = head1.next;
            head2 = head2.next;
        }

        return count;
    }

    public static void main(String[] args) {

        // Create the linked list 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);

        printList(head);

        LongestPalindromicList len = new LongestPalindromicList();
        System.out.println("Length of Longest Palindromic Linked List -> "+ len.solve(head));
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
