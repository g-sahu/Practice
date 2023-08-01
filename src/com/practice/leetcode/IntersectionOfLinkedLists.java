package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
160. Intersection of Two Linked Lists
 */
public class IntersectionOfLinkedLists {
    public static void main(String[] args) {
        IntersectionOfLinkedLists intersection = new IntersectionOfLinkedLists();
        int[] list1 = {4,1,8,4,5};
        int[] list2 = {5,6,1,8,4,5};
        ListNode head1 = LeetUtils.buildLinkedList(list1);
        ListNode head2 = LeetUtils.buildLinkedList(list2);
        ListNode intersectionNode = intersection.getIntersectionNode2(head1, head2);
        LeetUtils.printLinkedList(intersectionNode);
    }

    //Using HashSet
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    //Using two pointers
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int m = countNodes(headA);
        int n = countNodes(headB);
        int diff = Math.abs(m-n);

        if (m > n) {
            for (int i = 1; i <= diff; i++) {
                headA = headA.next;
            }
        } else if (m < n) {
            for (int i = 1; i <= diff; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int countNodes(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

}
