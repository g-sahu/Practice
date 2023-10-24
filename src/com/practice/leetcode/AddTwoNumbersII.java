package com.practice.leetcode;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = buildStack(l1);
        Stack<Integer> s2 = buildStack(l2);
        int c = 0;
        ListNode head = null;

        while(!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + c;

            if(sum >= 10) {
                c = sum / 10;
                sum = sum % 10;
            } else {
                c = 0;
            }

            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }

        if(c > 0) {
            ListNode node = new ListNode(c);
            node.next = head;
            head = node;
        }

        return head;
    }

    Stack<Integer> buildStack(ListNode node) {
        Stack<Integer> s = new Stack<>();

        while(node != null) {
            s.push(node.val);
            node = node.next;
        }

        return s;
    }
}
