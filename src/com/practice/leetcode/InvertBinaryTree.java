package com.practice.leetcode;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if(node != null) {
            dfs(node.left);
            dfs(node.right);

            //Swap left and right child
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
