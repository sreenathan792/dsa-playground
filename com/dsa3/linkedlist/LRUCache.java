package com.dsa3.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 * <p>
 * Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
 * <p>
 * NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * <p>
 * Example :
 * <p>
 * Input :
 * capacity = 2
 * set(1, 10)
 * set(5, 12)
 * get(5)        returns 12
 * get(1)        returns 10
 * get(10)       returns -1
 * set(6, 14)    this pushes out key = 5 as LRU is full.
 * get(5)        returns -1
 * Expected Output
 * Enter your input as per the following guideline:
 * There are 1 lines in the input
 * <p>
 * Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of number numOperations, capacity. capacity is the number your constructor is initialized with.
 * Then numOperation operations follow.
 * Each operation is either :
 * * G  : This corresponds to a function call get()
 * * S   : This corresponds to a function call set(num1, num2)
 * Note that the function calls are made in order.
 */

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            add(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node(key, value);
            add(node);
            cache.put(key, node);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        Node prev = head;
        Node next = head.next;
        prev.next = node;
        next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    public static void main(String[] args) {
        LRUCache solution = new LRUCache(2);
        solution.set(2, 1);
        solution.set(1, 1);
        solution.set(2, 3);
        solution.set(4, 1);
        System.out.println(solution.get(1));  // Output: -1
        System.out.println(solution.get(2));  // Output: 3
    }
}
