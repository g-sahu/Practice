package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
148. Sort List
 */
public class SortList {

    public static void main(String[] args) {
        SortList sl = new SortList();
        int[] list = {4,2,1,3};
        ListNode head = LeetUtils.buildLinkedList(list);
        ListNode sortedList = sl.sortList(head);
        LeetUtils.printLinkedList(sortedList);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);
        head = new ListNode(list.get(0));
        ListNode prev = head;

        for (int i = 1; i < list.size(); i++) {
            int n = list.get(i);
            prev.next = new ListNode(n);
            prev = prev.next;
        }

        return head;
    }
}
