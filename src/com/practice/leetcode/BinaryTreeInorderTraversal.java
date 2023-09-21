package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
94. Binary Tree Inorder Traversal
 */
public class BinaryTreeInorderTraversal {
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }

}
