package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            long sum = 0;

            for(int i=1; i<=size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }

            list.add((double) sum/size);
        }

        return list;
    }
}
