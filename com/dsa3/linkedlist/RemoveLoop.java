package com.dsa3.linkedlist;

/**
 * You are using Google Maps to help you find your way around a new place. But, you get lost and end up walking in a circle. Google Maps has a way to keep track of where you've been with the help of special sensors.These sensors notice that you're walking in a loop, and now, Google wants to create a new feature to help you figure out exactly where you started going in circles.
 * <p>
 * Here's how we can describe the challenge in simpler terms: You have a Linked List A that shows each step of your journey, like a chain of events. Some of these steps have accidentally led you back to a place you've already been, making you walk in a loop. The goal is to find out the exact point where you first started walking in this loop, and then you want to break the loop by not going in the circle just before this point.
 * <p>
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= number of nodes <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
 * The second line of the input contains an integer which denotes the position of node where cycle starts.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * return the head of the updated linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * <p>
 * 1 -> 2
 * ^    |
 * | - -
 * Input 2:
 * <p>
 * 3 -> 2 -> 4 -> 5 -> 6
 * ^         |
 * |         |
 * - - - - - -
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1 -> 2 -> NULL
 * Output 2:
 * <p>
 * 3 -> 2 -> 4 -> 5 -> 6 -> NULL
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Chain of 1->2 is broken.
 * Explanation 2:
 * <p>
 * Chain of 4->6 is broken.
 */
public class RemoveLoop {

    public ListNode solve(ListNode A) {

        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        ListNode x = A;
        ListNode y = fast;
        ListNode prev = null;
        while (x != y) {
            prev = y;
            x = x.next;
            y = y.next;
        }

        prev.next = null;

        return A;

    }

    public static void main(String[] args) {

        // Create the linked list 3->4->2->8->4
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = head.next;

        RemoveLoop rem = new RemoveLoop();
        ListNode sorted = rem.solve(head);

        printList(sorted);
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
