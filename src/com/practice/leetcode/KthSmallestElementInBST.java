package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInBST {
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k-1);
    }

    void inorder(TreeNode node) {
        if(node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }
}
