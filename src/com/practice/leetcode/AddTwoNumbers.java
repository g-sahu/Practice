package com.practice.leetcode;

import java.util.Stack;

import static com.practice.leetcode.LeetUtils.buildLinkedList;
import static com.practice.leetcode.LeetUtils.printLinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        /*
         * l1 = [9, 9, 9]
         * l2 = [9, 9, 9]
         *       18,
         */

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = buildLinkedList(new int[]{2,4,3});
        ListNode l2 = buildLinkedList(new int[]{5,6,4});

        //[7, 0, 1]
        ListNode listNode = a.addTwoNumbers(l1, l2);
        printLinkedList(listNode);

        Stack<Integer> stack = new Stack<>();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int sum = l1.val + l2.val;
        int s = sum % 10;
        int c = sum / 10;
        ListNode h = new ListNode(s);
        ListNode l = h;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            sum = v1 + v2 + c;
            c = sum / 10;
            s = sum % 10;

            if (l1 == null && l2 == null && sum == 0) {
                return h;
            }

            l.next = new ListNode(s);
            l = l.next;
        }

        return h;
    }

    static int getSize(ListNode l) {
        int size = 0;

        while(l != null) {
            size++;
            l = l.next;
        }

        return size;
    }
}
