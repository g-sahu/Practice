package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/*
234. Palindrome Linked List
 */
public class PalindromeLinkedList {
    private ListNode first;

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        int[] list = {1,2,3,4,2,1};
        ListNode listNode = LeetUtils.buildLinkedList(list);
        System.out.println(pll.isPalindrome3(listNode));
    }

    //Using Stack
    public boolean isPalindrome1(ListNode head) {
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

    //Using ArrayList
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i <= j){
            if (!Objects.equals(list.get(i), list.get(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    //With recursion
    public boolean isPalindrome3(ListNode head) {
        first = head;
        return isPal(first);
    }

    private boolean isPal(ListNode node) {
        if (node.next == null) {
            return first.val == node.val;
        } else {
            if(isPal(node.next)) {
                first = first.next;
                return first.val == node.val;
            } else {
                return false;
            }
        }
    }
}
