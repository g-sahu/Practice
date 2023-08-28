package com.practice.leetcode;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("java:S106")
public class LeetUtils {
    private LeetUtils() {}

    public static ListNode buildLinkedList(int[] list) {
        if (list == null || list.length == 0) {
            return null;
        }

        int size = list.length;
        ListNode listNode = new ListNode(list[0]);
        ListNode head = listNode;

        for (int i = 1; i < size; i++) {
            listNode.next = new ListNode(list[i]);
            listNode = listNode.next;
        }

        return head;
    }

    public static void printLinkedList(ListNode listNode) {
        System.out.print("[");

        while (listNode != null) {
            System.out.print(listNode.val);

            if (listNode.next != null) {
                System.out.print(", ");
            }

            listNode = listNode.next;
        }

        System.out.print("]");
    }

    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
              .map(Arrays :: toString)
              .forEach(System.out :: println);
    }

    public static void printNestedLists(List<List<Integer>> lists) {
        lists.forEach(System.out :: println);
    }

    //Creates a binary tree from an array using level order traversal (BFS)
    public static TreeNode buildTree(Integer[] arr) {
        //TODO: Implement this
        return null;
    }
}
