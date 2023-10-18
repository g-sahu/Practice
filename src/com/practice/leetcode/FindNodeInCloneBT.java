package com.practice.leetcode;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */
public class FindNodeInCloneBT {
    TreeNode ans;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned, target);
        return ans;
    }

    void dfs(TreeNode node, TreeNode target) {
        if(node != null) {
            if(node.val == target.val) {
                ans = node;
            }
            dfs(node.left, target);
            dfs(node.right, target);
        }
    }
}
