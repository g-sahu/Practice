package com.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 100. Same Tree
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<List<Integer>> l1 = bfs(p);
        List<List<Integer>> l2 = bfs(q);
        return l1.equals(l2);
    }

    List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=1; i<=n; i++) {
                TreeNode node = q.poll();

                if(node == null) {
                    level.add(null);
                } else {
                    level.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }

            list.add(level);
        }

        return list;
    }
}
