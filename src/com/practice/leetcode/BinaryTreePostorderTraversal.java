package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    private void traverse(TreeNode node) {
        if(node != null) {
            traverse(node.left);
            traverse(node.right);
            list.add(node.val);
        }
    }
}
