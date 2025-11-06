package com.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 */
public class SymmetricTree {

    // Recursive solution
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both nodes are null
        if(t1 == null && t2 == null) {
            return true;
        }

        // One of the node is null
        if(t1 == null || t2 == null) {
            return false;
        }

        // Node values are different
        if(t1.val != t2.val) {
            return false;
        }

        // Compare left child of left node with right child of right node and vice-versa
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // Iterative solution
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if(t1 == null && t2 == null) {
                continue;
            }
            if(t1 == null || t2 == null) {
                return false;
            }
            if(t1.val != t2.val) {
                return false;
            }

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }

        return true;
    }
}
