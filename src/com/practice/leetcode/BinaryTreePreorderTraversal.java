package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    private void traverse(TreeNode node) {
        if(node != null) {
            list.add(node.val);
            traverse(node.left);
            traverse(node.right);
        }
    }
}
