package com.test.linkedlist;

import java.util.HashMap;

/**
 * You are given a linked list A
 * Each node in the linked list contains two pointers: a next pointer and a random pointer
 * The next pointer points to the next node in the list
 * The random pointer can point to any node in the list, or it can be NULL
 * Your task is to create a deep copy of the linked list A
 * The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
 * You should create a new linked list B, where each node in B has the same value as the corresponding node in A
 * The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= |A| <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument of input contains a pointer to the head of linked list A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a pointer to the head of the required linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Given list
 * 1 -> 2 -> 3
 * with random pointers going from
 * 1 -> 3
 * 2 -> 1
 * 3 -> 1
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * 1 -> 2 -> 3
 * with random pointers going from
 * 1 -> 3
 * 2 -> 1
 * 3 -> 1
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode head2 = new RandomListNode(head.label);

        RandomListNode temp = head;
        RandomListNode temp2 = head2;

        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        hm.put(temp,temp2);
        while(temp.next != null) {
            temp2.next = new RandomListNode(temp.next.label);
            hm.put(temp.next, temp2.next);
            temp = temp.next;
            temp2 = temp2.next;
        }

        temp = head;
        temp2 = head2;
        while(temp!= null) {
            temp2.random = hm.get(temp.random);
            temp = temp.next;
            temp2 = temp2.next;
        }

        return head2;

    }

    public static void main(String[] args) {

        // Create the linked list 1->2->3
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);

        //Add random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head;

        //ListNode head = new ListNode(7);

        printList(head);

        int position = 0;
        CopyRandomList ranCopy = new CopyRandomList();
        head = ranCopy.copyRandomList(head);

        printList(head);
    }

    public static void printList(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            System.out.print(curr.label + "->");
            curr = curr.next;
        }
        System.out.println();
    }
}
