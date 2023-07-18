package com.practice.leetcode;

/*
876. Middle of the Linked List
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        MiddleOfLinkedList moll = new MiddleOfLinkedList();
        int[] list = {1};
        ListNode head = LeetUtils.buildLinkedList(list);
        System.out.println(moll.middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;

        while (head != null && head.next != null) {
            slow = slow.next;
            head = head.next.next;
        }

        return slow;
    }
}
