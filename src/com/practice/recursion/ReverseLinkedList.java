package com.practice.recursion;

import com.practice.leetcode.ListNode;

import java.util.Stack;

import static com.practice.leetcode.LeetUtils.buildLinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        int[] list = new int[]{1, 2, 3, 4};
        ListNode listNode = buildLinkedList(list);
        rl.reverseList(listNode);
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while(head != null) {
            ListNode t = head;
            head = head.next;
            t.next = null;
            stack.push(t);
        }

        ListNode prev = null;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();

            if (prev == null) {
                head = node;
            } else {
                prev.next = node;
            }

            prev = node;
        }

        return head;
    }
}
