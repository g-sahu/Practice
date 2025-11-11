package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 */
public class BalanceBST {
    List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return bst(0, list.size() - 1);
    }

    TreeNode bst(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = bst(start, mid-1);
        node.right = bst(mid+1, end);
        return node;
    }

    void inorder(TreeNode node) {
        if(node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }
}
