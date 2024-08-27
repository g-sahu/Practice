package com.practice.leetcode;

/**
 * 938. Range Sum of BST
 */
public class RangeSumOfBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        preorder(root, low, high);
        return sum;
    }

    void preorder(TreeNode node, int low, int high) {
        if(node != null) {
            int val = node.val;

            if(low <= val && val <= high) {
                sum += val;
            }
            if(low < val) {
                preorder(node.left, low, high);
            }
            if(high > val) {
                preorder(node.right, low, high);
            }
        }
    }
}
