package com.practice.datastructures.trees;

import com.practice.leetcode.TreeNode;

class BinarySearchTree {
    TreeNode root;

    BinarySearchTree(int root) {
        this.root = new TreeNode(root);
    }

    void addNode(int val) {
        TreeNode temp = root;

        while(true) {
            if(val < temp.val) {
                if(temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else if(val > temp.val) {
                if(temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                break;
            }
        }
    }
}
