package com.practice.leetcode;

/*
700. Search in a Binary Search Tree
 */
public class SearchBST {

    //Iterative
    public TreeNode searchBST1(TreeNode root, int val) {
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

    //Recursive
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root != null) {
            if (val < root.val) {
                root = searchBST2(root.left, val);
            } else if (val > root.val) {
                root = searchBST2(root.right, val);
            } else {
                return root;
            }
        }

        return root;
    }
}
