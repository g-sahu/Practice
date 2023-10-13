package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 */
public class MinimumDepthOfBinaryTree {
    int min = Integer.MAX_VALUE;

    //DFS
    public int minDepth1(TreeNode root) {
        dfs(root, 1);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    void dfs(TreeNode node, int level) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                min = Math.min(min, level);
            }

            dfs(node.left, level+1);
            dfs(node.right, level+1);
        }
    }

    //BFS
    public int minDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()) {
            int n = q.size();
            level++;

            for(int i=1; i<=n; i++) {
                TreeNode node = q.poll();

                if(node.left == null && node.right == null) {
                    return level;
                }
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return level;
    }
}
