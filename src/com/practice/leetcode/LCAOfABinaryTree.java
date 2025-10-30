package com.practice.leetcode;

import java.util.Stack;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LCAOfABinaryTree {
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preorder(root, p, s1);
        preorder(root, q, s2);

        int s = Math.min(s1.size(), s2.size());
        TreeNode lca = root;

        for(int i=0; i<s; i++) {
            TreeNode n1 = s1.get(i);
            TreeNode n2 = s2.get(i);

            if(n1.val == n2.val) {
                lca = n1;
            } else {
                return lca;
            }
        }

        return lca;
    }

    boolean preorder(TreeNode node, TreeNode x, Stack<TreeNode> stack) {
        if(node != null) {
            stack.push(node);

            if(node.val == x.val) {
                return true;
            }

            boolean found = preorder(node.left, x, stack);

            if(!found) {
                found = preorder(node.right, x, stack);

                if(!found) {
                    stack.pop();
                }
            }

            return found;
        }

        return false;
    }
}
