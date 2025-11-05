package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LCAOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        preorder(root, p, l1);
        preorder(root, q, l2);

        int s = Math.min(l1.size(), l2.size());
        TreeNode lca = root;

        for(int i=0; i<s; i++) {
            TreeNode n1 = l1.get(i);
            TreeNode n2 = l2.get(i);

            if(n1 != n2) {
                break;
            }

            lca = n1;
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
}
