package com.practice.datastructures.trees;

import com.practice.leetcode.TreeNode;

class BinaryTree {
    TreeNode root;

    BinaryTree(int root) {
        this.root = new TreeNode(root);
    }

    void addNode(TreeNode parent, TreeNode child, Position position) {
        switch (position) {
            case LEFT:
                insertLeftChild(parent, child);
                break;
            case RIGHT:
                insertRightChild(parent, child);
                break;

        }
    }

    private void insertLeftChild(TreeNode parent, TreeNode child) {
        parent.left = child;
    }

    private void insertRightChild(TreeNode parent, TreeNode child) {
        parent.right = child;
    }

    enum Position { LEFT, RIGHT }
}
