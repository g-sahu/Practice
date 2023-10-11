package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 107. Binary Tree Level Order Traversal II
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=1; i<=n; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }

            stack.push(level);
        }

        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }
}
