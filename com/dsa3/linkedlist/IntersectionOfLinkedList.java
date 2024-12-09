package com.dsa3.linkedlist;

/**
 * Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * NOTE:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * The custom input to be given is different than the one explained in the examples. Please be careful.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= |A|, |B| <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument of input contains a pointer to the head of the linked list A.
 * <p>
 * The second argument of input contains a pointer to the head of the linked list B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a pointer to the node after which the linked list is intersecting.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = [6, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [1, 2, 3]
 * B = [4, 5]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [3, 4, 5]
 * Output 2:
 * <p>
 * []
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point.
 * Explanation 2:
 * <p>
 * In the second example, the nodes don't have the same values, thus we can return None/Null.
 */
public class IntersectionOfLinkedList {

    public ListNode getIntersectionNode(ListNode A, ListNode B) {

        if(A == null || B == null)
            return null;

        ListNode temp1 = A;
        int aLen = 0;
        while(temp1!=null) {
            aLen++;
            temp1 = temp1.next;
        }

        ListNode temp2 = B;
        int bLen = 0;
        while(temp2!=null) {
            bLen++;
            temp2 = temp2.next;
        }

        int lenDiff = Math.abs(aLen-bLen);
        ListNode curr1 = A;
        ListNode curr2 = B;
        if(aLen < bLen) {
            //advance B to A's head position
            for(int i = 0; i<lenDiff; i++) {
                curr2 = curr2.next;
            }
        } else if (bLen < aLen) {
            //advance A to B's head position
            for(int i = 0; i<lenDiff; i++) {
                curr1 = curr1.next;
            }
        }

        while(curr1!=null && curr2!=null) {

            if(curr1.val == curr2.val) {
                break;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return curr1;
    }

    public static void main(String[] args) {


        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        // Create the linked list 1->2->3->4->5
        ListNode head1 = n1;
        head1.next = n2;
        head1.next.next = n3;
        head1.next.next.next = n4;
        head1.next.next.next.next = n5;

        printList(head1);

        // Create the linked list 6->3->4->5
        ListNode head2 = n6;
        head2.next = n3;
        head2.next.next = n4;
        head2.next.next.next = n5;

        printList(head2);

        IntersectionOfLinkedList intersect = new IntersectionOfLinkedList();
        ListNode matching = intersect.getIntersectionNode(head1, head2);

        printList(matching);
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
