package com.practice.leetcode;

import com.practice.leetcode.utils.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 314. Binary Tree Vertical Order Traversal
 */
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, 0));

        while(!q.isEmpty()) {
            int n = q.size();

            for(int i=1; i<=n; i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode node = p.getKey();
                int c = p.getValue();

                List<Integer> col = map.getOrDefault(c, new ArrayList<>());
                col.add(node.val);
                map.put(c, col);

                if(node.left != null) {
                    q.offer(new Pair<>(node.left, c-1));
                }
                if(node.right != null) {
                    q.offer(new Pair<>(node.right, c+1));
                }
            }
        }

        list.addAll(map.values());
        return list;
    }
}
