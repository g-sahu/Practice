package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1302. Deepest Leaves Sum
 */
public class DeepestLeavesSum {
    int max, sum;

    //DFS
    public int deepestLeavesSum1(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }

    void preOrder(TreeNode node, int l) {
        if(node != null) {
            if(l > max) {
                sum = node.val;
                max = l;
            } else if (l == max){
                sum += node.val;
            }
            preOrder(node.left, l+1);
            preOrder(node.right, l+1);
        }
    }

    //BFS
    public int deepestLeavesSum2(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int sum=0;

        while(!q.isEmpty()) {
            int n = q.size();
            sum=0;

            for(int i=0; i<n; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return sum;
    }
}
