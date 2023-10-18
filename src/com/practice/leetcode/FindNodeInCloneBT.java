package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */
public class FindNodeInCloneBT {
    TreeNode ans;

    //Using DFS
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
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

    //Using BFS
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(cloned);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 1; i <= n; i++) {
                TreeNode node = q.poll();

                if (node.val == target.val) {
                    return node;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return null;
    }
}
