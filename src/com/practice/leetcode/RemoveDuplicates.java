package com.practice.leetcode;

/*
83. Remove Duplicates from Sorted List
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] list = {1,1,3,3};
        ListNode head = LeetUtils.buildLinkedList(list);
        ListNode listNode = rd.deleteDuplicates(head);
        LeetUtils.printLinkedList(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (current.val == prev.val) {
                prev.next = current.next;
                current.next = null;
            } else {
                prev = prev.next;
            }

            current = prev.next;
        }

        return head;
    }
}
