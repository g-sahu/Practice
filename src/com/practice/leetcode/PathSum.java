package com.practice.leetcode;

/**
 * 112. Path Sum
 */
public class PathSum {
    int t;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        t = targetSum;
        return preorder(root, 0);
    }

    boolean preorder(TreeNode node, int sum) {
        if(node != null) {
            sum += node.val;

            if(node.left == null && node.right == null) {
                return sum == t;
            }

            return preorder(node.left, sum) || preorder(node.right, sum);
        }
        return false;
    }
}
