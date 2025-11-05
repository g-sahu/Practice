package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LCAOfABinaryTree {

    // With extra space
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        preorder(root, p, l1);
        preorder(root, q, l2);

        int s = Math.min(l1.size(), l2.size());
        TreeNode lca = root;

        for(int i=0; i<s; i++) {
            if(l1.get(i) != l2.get(i)) {
                break;
            }

            lca = l1.get(i);
        }

        return lca;
    }

    boolean preorder(TreeNode node, TreeNode x, List<TreeNode> list) {
        if(node == null) {
            return false;
        }

        list.add(node);

        if(node == x) {
            return true;
        }

        if(preorder(node.left, x, list) || preorder(node.right, x, list)) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }

    // Without extra space
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: null or one of the targets
        if (root == null || root == p || root == q) {
            return root;
        }

        // Check left and right subtrees
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        // If both sides found something, this node is where they meet
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, propagate the non-null result upward
        return (left != null) ? left : right;
    }
}
