package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        List<ListNode> nodes = splitNodes(list1);
        nodes.addAll(splitNodes(list2));
        nodes.sort(Comparator.comparingInt(node -> node.val));

        ListNode mergedList = new ListNode();
        ListNode head = mergedList;

        for (ListNode node : nodes) {
            mergedList.next = node;
            mergedList = node;
        }

        return head;
    }

    List<ListNode> splitNodes(ListNode listNode) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode h = listNode;

        while (h != null) {
            h = h.next;
            listNode.next = null;
            nodes.add(new ListNode(listNode.val));
            listNode = h;
        }

        return nodes;
    }

    static void printNodes(List<ListNode> nodes) {
        System.out.println("Nodes: " +
                nodes.stream()
                     .map(node -> String.valueOf(node.val))
                     .collect(Collectors.joining(","))
        );
    }
}
