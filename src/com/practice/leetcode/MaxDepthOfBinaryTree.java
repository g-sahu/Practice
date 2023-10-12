package com.practice.leetcode;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaxDepthOfBinaryTree {
    int h;

    public int maxDepth(TreeNode root) {
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
}
