package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int n = q.size();
            int max = Integer.MIN_VALUE;

            for(int i=1; i<=n; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }

            list.add(max);
        }

        return list;
    }
}
