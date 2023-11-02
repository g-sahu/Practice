package com.practice.leetcode;

/**
 * 2265. Count Nodes Equal to Average of Subtree
 */
public class CountNodesEqualToAvgOfSubtree {
    int ans;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode node) {
        if(node != null) {
            int[] l = dfs(node.left);
            int[] r = dfs(node.right);
            int sum = l[0] + r[0] + node.val;
            int n = l[1] + r[1] + 1;
            int avg = sum/n;

            if(node.val == avg) {
                ans++;
            }

            return new int[]{sum, n};
        }

        return new int[]{0, 0};
    }
}
