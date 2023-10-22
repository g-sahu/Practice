package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 */
public class ValidateBST {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        int prev = list.get(0);

        for(int i=1; i<list.size(); i++) {
            int n = list.get(i);

            if(n <= prev) {
                return false;
            }
            prev = n;
        }

        return true;
    }

    void dfs(TreeNode node) {
        if(node != null) {
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        }
    }
}
