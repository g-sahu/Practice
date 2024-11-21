package com.practice.leetcode;

/**
 * 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {
    int c;

    //DFS
    public int countNodes(TreeNode root) {
        preorder(root);
        return c;
    }

    void preorder(TreeNode node) {
        if(node != null) {
            c++;
            preorder(node.left);
            preorder(node.right);
        }
    }

}
