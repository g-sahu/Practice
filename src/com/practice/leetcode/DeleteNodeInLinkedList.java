package com.practice.leetcode;

/*
237. Delete Node in a Linked List
 */
public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            swap(node);
            node = node.next;
        }

        swap(node);
        node.next = null;
    }

    private static void swap(ListNode node) {
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;
    }
}
