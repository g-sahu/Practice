package com.practice.leetcode;

public class IncreasingOrderSearchTree {
    private TreeNode root;
    private TreeNode temp;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;

        IncreasingOrderSearchTree i = new IncreasingOrderSearchTree();
        i.increasingBST(node5);
    }

    public TreeNode increasingBST(TreeNode node) {
        root = new TreeNode(node.val);
        temp = root;
        inorder(node);
        return root;
    }

    private void inorder(TreeNode node) {
        if(node != null) {
            inorder(node.left);
            temp.right = new TreeNode(node.val);
            temp = temp.right;
            inorder(node.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
