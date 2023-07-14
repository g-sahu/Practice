package com.practice.leetcode;

import java.util.Stack;

/*
234. Palindrome Linked List
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        int[] list = {1,2,2,1};
        ListNode listNode = LeetUtils.buildLinkedList(list);
        System.out.println(pll.isPalindrome(listNode));
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;

        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }

            head = head.next;
        }

        return true;
    }
}
