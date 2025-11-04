package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInBST {
    List<Integer> list = new ArrayList<>();
    int c=0;

    public int kthSmallest(TreeNode root, int k) {
        inorder1(root);
        return list.get(k-1);
    }

    //With extra space
    void inorder1(TreeNode node) {
        if(node != null) {
            inorder1(node.left);
            list.add(node.val);
            inorder1(node.right);
        }
    }

    //Without extra space
    int inorder2(TreeNode node, int k) {
        if(node != null) {
            int r = inorder2(node.left, k);

            if(r == -1) {
                c++;

                if(c == k) {
                    return node.val;
                }

                return inorder2(node.right, k);
            } else {
                return r;
            }
        }

        return -1;
    }
}
