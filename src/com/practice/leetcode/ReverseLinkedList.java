package com.practice.leetcode;

import java.util.Stack;

import static com.practice.leetcode.LeetUtils.buildLinkedList;
import static com.practice.leetcode.LeetUtils.printLinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        int[] list = new int[]{1, 2, 3, 4};
        ListNode listNode = buildLinkedList(list);

        System.out.print("Reversed in-place: ");
        printLinkedList(rl.reverseList(listNode));

        /*System.out.print("Reversed with Stack: ");
        printLinkedList(rl.reverseListWithStack(listNode));*/
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public ListNode reverseListWithStack(ListNode head) {
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
