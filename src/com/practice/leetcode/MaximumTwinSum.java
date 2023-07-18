package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
2130. Maximum Twin Sum of a Linked List
 */
public class MaximumTwinSum {
    public static void main(String[] args) {
        MaximumTwinSum mts = new MaximumTwinSum();
        int[] list = {5,4,2,1};
        ListNode head = LeetUtils.buildLinkedList(list);
        System.out.println(mts.pairSum2(head));
    }

    //With Array
    public int pairSum1(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;
        int maxSum = 0;

        while (i < j) {
            int sum = list.get(i) + list.get(j);
            maxSum = sum > maxSum ? sum : maxSum;
            i++;
            j--;
        }

        return maxSum;
    }

    //With Stack
    public int pairSum2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;

        while (head != null) {
            stack.push(slow.val);
            head = head.next.next;
            slow = slow.next;
        }

        int maxSum = 0;

        while (slow != null) {
            int sum = slow.val + stack.pop();
            maxSum = sum > maxSum ? sum : maxSum;
            slow = slow.next;
        }

        return maxSum;
    }
}
