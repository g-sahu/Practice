package com.practice.leetcode;

/**
 * 1302. Deepest Leaves Sum
 */
public class DeepestLeavesSum {
    int max, sum;

    public int deepestLeavesSum(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }

    void preOrder(TreeNode node, int l) {
        if(node != null) {
            if(l > max) {
                sum = node.val;
                max = l;
            } else if (l == max){
                sum += node.val;
            }
            preOrder(node.left, l+1);
            preOrder(node.right, l+1);
        }
    }
}
