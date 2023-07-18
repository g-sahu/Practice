package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
2130. Maximum Twin Sum of a Linked List
 */
public class MaximumTwinSum {
    public static void main(String[] args) {
        MaximumTwinSum mts = new MaximumTwinSum();
        int[] list = {5,4,2,1};
        ListNode head = LeetUtils.buildLinkedList(list);
        System.out.println(mts.pairSum(head));
    }

    public int pairSum(ListNode head) {
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
}
