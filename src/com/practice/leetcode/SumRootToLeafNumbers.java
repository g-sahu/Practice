package com.practice.leetcode;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int c) {
        if(node == null) {
            return 0;
        }

        c = c*10 + node.val;

        if(node.left == null && node.right == null) {
            return c;
        }

        return dfs(node.left, c) + dfs(node.right, c);
    }
}
