package com.practice.leetcode;

/*
328. Odd Even Linked List
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        OddEvenLinkedList oell = new OddEvenLinkedList();
        int[] list = {1,2,3,4,5,6,7,8};
        ListNode head = LeetUtils.buildLinkedList(list);
        LeetUtils.printLinkedList(oell.oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        ListNode temp = head;
        int n = 1;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        ListNode newTail = tail;
        int i = 1;

        while (i < n) {
            newTail.next = temp.next;
            newTail = newTail.next;
            temp.next = temp.next.next;
            newTail.next = null;
            temp = temp.next;
            i += 2;
        }

        return head;
    }
}
