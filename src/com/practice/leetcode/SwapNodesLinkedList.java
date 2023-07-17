package com.practice.leetcode;

/*
1721. Swapping Nodes in a Linked List
 */
public class SwapNodesLinkedList {
    public static void main(String[] args) {
        SwapNodesLinkedList snll = new SwapNodesLinkedList();
        int[] list = {1,2,3,4,5};
        ListNode head = LeetUtils.buildLinkedList(list);
        ListNode node = snll.swapNodes(head, 2);
        LeetUtils.printLinkedList(node);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode tail = head;

        for (int i = 1; i < k; i++) {
            tail = tail.next;
        }

        while (tail.next != null) {
            right = right.next;
            tail = tail.next;
        }

        for (int i = 1; i < k; i++) {
            left = left.next;
        }

        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}
