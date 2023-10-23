package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int n = q.size();

            for(int i=1; i<=n; i++) {
                TreeNode node = q.poll();

                if(i == n) {
                    list.add(node.val);
                }

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return list;
    }
}
