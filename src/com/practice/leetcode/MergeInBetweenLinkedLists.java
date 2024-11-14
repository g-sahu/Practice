package com.practice.leetcode;

/**
 * 1669. Merge In Between Linked Lists
 */
public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode l1, int a, int b, ListNode l2) {
        ListNode start = null, end = null, t = l1;
        int i = 0;

        while (t != null) {
            if (i == a - 1) {
                start = t;
            }
            if (i == b) {
                end = t;
            }
            if (start != null && end != null) {
                break;
            }
            t = t.next;
            i++;
        }

        start.next = l2;
        t = l2;

        while (t.next != null) {
            t = t.next;
        }

        t.next = end.next;
        return l1;
    }
}
