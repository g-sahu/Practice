package com.practice.leetcode;

/*
141. Linked List Cycle
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        ListNode fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            if (head == fast) {
                return true;
            } else {
                fast = fast.next.next;
                head = head.next;
            }
        }

        return false;
    }
}
