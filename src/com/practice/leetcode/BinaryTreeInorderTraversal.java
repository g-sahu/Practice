package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 */
public class BinaryTreeInorderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    private void traverse(TreeNode node) {
        if(node != null) {
            traverse(node.left);
            list.add(node.val);
            traverse(node.right);
        }
    }
}
