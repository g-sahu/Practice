package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

    //Iterative
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodes = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < nodes; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            list.add(level);
        }

        return list;
    }

    //Recursive
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        traverse(output, root, 0);
        return output;
    }

    public void traverse(List<List<Integer>> output, TreeNode root, int level) {
        if (root != null) {
            if (level >= output.size()) {
                output.add(new ArrayList<>());
            }
            output.get(level).add(root.val);
            traverse(output, root.left, level + 1);
            traverse(output, root.right, level + 1);
        }
    }
}
