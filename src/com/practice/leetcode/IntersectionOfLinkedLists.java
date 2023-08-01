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
        ListNode intersectionNode = intersection.getIntersectionNode(head1, head2);
        LeetUtils.printLinkedList(intersectionNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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

}
