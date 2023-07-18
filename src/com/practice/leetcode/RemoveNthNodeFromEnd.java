package com.practice.leetcode;

/*
19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        RemoveNthNodeFromEnd rn = new RemoveNthNodeFromEnd();
        int[] list = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = LeetUtils.buildLinkedList(list);
        ListNode node = rn.removeNthFromEnd(head, 7);
        LeetUtils.printLinkedList(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode prev = head; //Node preceding the target node
        ListNode temp = head;

        for (int i = 1; i < n; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            head = head.next;
        } else {
            while (temp.next != null && temp.next.next != null) {
                prev = prev.next;
                temp = temp.next;
            }

            //Delete Node
            ListNode node = prev.next;
            prev.next = prev.next.next;
            node.next = null;
        }

        return head;
    }
}
