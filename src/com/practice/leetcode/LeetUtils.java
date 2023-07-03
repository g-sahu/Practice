package com.practice.leetcode;

@SuppressWarnings("java:S106")
public class LeetUtils {
    private LeetUtils() {}

    public static ListNode buildLinkedList(int[] list) {
        if (list == null || list.length == 0) {
            return null;
        }

        int size = list.length;
        ListNode listNode = new ListNode(list[0]);
        ListNode head = listNode;

        for (int i = 1; i < size; i++) {
            listNode.next = new ListNode(list[i]);
            listNode = listNode.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode listNode) {
        System.out.print("[");

        while (listNode != null) {
            System.out.print(listNode.val);

            if (listNode.next != null) {
                System.out.print(", ");
            }

            listNode = listNode.next;
        }

        System.out.print("]");
    }
}
