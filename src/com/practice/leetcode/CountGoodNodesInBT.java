package com.practice.leetcode;

/**
 * 1448. Count Good Nodes in Binary Tree
 */
public class CountGoodNodesInBT {
    int c;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return c;
    }

    void dfs(TreeNode node, int max) {
        if(node != null) {
            int val = node.val;

            if(val >= max) {
                c++;
                max = val;
            }

            dfs(node.left, max);
            dfs(node.right, max);
        }
    }
}
