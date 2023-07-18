package com.practice.leetcode;

/*
2095. Delete the Middle Node of a Linked List
 */
public class DeleteMiddleOfLinkedList {
    public static void main(String[] args) {
        DeleteMiddleOfLinkedList dmoll = new DeleteMiddleOfLinkedList();
        int[] list = {1,2,3,4,5};
        ListNode head = LeetUtils.buildLinkedList(list);
        LeetUtils.printLinkedList(dmoll.deleteMiddle(head));
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head.next == null) {
            return null;
        }

        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Delete node
        ListNode temp = slow.next;
        slow.next = temp.next;
        temp.next = null;
        return head;
    }
}
