package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    void dfs(TreeNode node, List<Integer> list) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                list.add(node.val);
            } else {
                dfs(node.left, list);
                dfs(node.right, list);
            }
        }
    }
}
