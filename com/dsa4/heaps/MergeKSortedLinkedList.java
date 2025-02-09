package com.dsa4.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Given a list containing head pointers of N sorted linked lists.
 * Merge these given sorted linked lists and return them as one sorted list.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= total number of elements in given linked lists <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and only argument is a list containing N head pointers.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a pointer to the head of the sorted linked list after merging all the given linked lists.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * Input 2:
 * <p>
 * 10 -> 12
 * 13
 * 5 -> 6
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * Output 2:
 * <p>
 * 5 -> 6 -> 10 -> 12 ->13
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
 * Explanation 2:
 * <p>
 * The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
 */
public class MergeKSortedLinkedList {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((m, n) -> m.val - n.val);
        int n = a.size();
        for(int i = 0; i<n; i++) {
            pq.add(a.get(i));
        }

        while(!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            temp.next = smallest;
            temp = temp.next;
            if(smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }

}
