package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int l = 1;

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

            if(l++ % 2 == 0) {
                Collections.reverse(level);
            }

            list.add(level);
        }

        return list;
    }
}
