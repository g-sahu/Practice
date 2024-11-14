package com.practice.leetcode;

/**
 * 538. Convert BST to Greater Tree
 */
public class ConvertBSTToGreaterTree {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        calculateSum(root);
        System.out.println(sum);
        inorder(root);
        return root;
    }

    void calculateSum(TreeNode node) {
        if(node != null) {
            calculateSum(node.left);
            sum += node.val;
            calculateSum(node.right);
        }
    }

    void inorder(TreeNode node) {
        if(node != null) {
            inorder(node.left);
            sum -= node.val;
            node.val = node.val + sum;
            inorder(node.right);
        }
    }
}
