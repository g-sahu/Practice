package com.practice.leetcode;

import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTreeToLinkedList {
    Stack<TreeNode> stack = new Stack<>();

    public void flatten(TreeNode root) {
        if(root != null) {
            preorder(root);
            TreeNode prev = stack.pop();
            prev.left = null;
            prev.right = null;

            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                node.left = null;
                node.right = prev;
                prev = node;
            }
        }
    }

    void preorder(TreeNode node) {
        if(node != null) {
            stack.push(node);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
