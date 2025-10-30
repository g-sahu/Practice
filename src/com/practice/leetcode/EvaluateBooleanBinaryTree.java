package com.practice.leetcode;

/**
 * 2331. Evaluate Boolean Binary Tree
 */
public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        return evaluate(root);
    }

    boolean evaluate(TreeNode node) {
        int v = node.val;

        if(node.left != null && node.right != null) {
            if(v == 2) {
                return evaluate(node.left) || evaluate(node.right);
            } else {
                return evaluate(node.left) && evaluate(node.right);
            }
        } else {
            return v == 1;
        }
    }
}
