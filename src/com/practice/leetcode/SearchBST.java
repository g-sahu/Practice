package com.practice.leetcode;

/*
700. Search in a Binary Search Tree
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return root;
    }
}
