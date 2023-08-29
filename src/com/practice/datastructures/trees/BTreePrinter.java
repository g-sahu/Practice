package com.practice.datastructures.trees;

import com.practice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.pow;
import static java.util.Collections.singletonList;

class BTreePrinter {

    static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) pow(2, (max(floor - 1, 0)));
        int firstSpaces = (int) pow(2, (floor)) - 1;
        int betweenSpaces = (int) pow(2, (floor + 1)) - 1;
        printWhitespaces(firstSpaces);
        List<TreeNode> newNodes = new ArrayList<>();

        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }

        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (TreeNode node : nodes) {
                printWhitespaces(firstSpaces - i);

                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (node.right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }
}
