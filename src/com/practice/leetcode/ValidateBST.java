package com.practice.leetcode;

/**
 * 98. Validate Binary Search Tree
 */
public class ValidateBST {
    Integer prev;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }

    void dfs(TreeNode node) {
        if(node != null) {
            dfs(node.left);

            if(prev != null && node.val <= prev) {
                isValid = false;
            }
            prev = node.val;

            dfs(node.right);
        }
    }
}
