package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 */
public class MaximumLevelSumOfBT {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int l = 1;
        int max = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int n = q.size();
            int sum = 0;

            for(int i=1; i<=n; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }

            if(sum > max) {
                max = sum;
                ans = l;
            }
            l++;
        }

        return ans;
    }
}
