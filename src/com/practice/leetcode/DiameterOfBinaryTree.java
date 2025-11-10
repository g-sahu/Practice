package com.practice.leetcode;

/**
 * 543. Diameter of Binary Tree
 */
public class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    int height(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);
        diameter = Math.max(diameter, lh+rh);
        return Math.max(lh, rh) + 1;
    }
}
