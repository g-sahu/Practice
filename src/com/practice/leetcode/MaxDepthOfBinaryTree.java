package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaxDepthOfBinaryTree {
    int h;

    //DFS
    public int maxDepth1(TreeNode root) {
        dfs(root, 1);
        return h;
    }

    private void dfs(TreeNode node, int l) {
        if(node != null) {
            h = Math.max(h, l);
            dfs(node.left, l+1);
            dfs(node.right, l+1);
        }
    }

    //BFS
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int l = 0;

        while(!q.isEmpty()) {
            int n = q.size();
            l++;

            for(int i=1; i<=n; i++) {
                TreeNode node = q.poll();

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return l;
    }
}
