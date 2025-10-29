package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. Binary Tree Paths
 */
public class BinaryTreePaths {
    Stack<TreeNode> stack = new Stack<>();
    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        preorder(root);
        return paths;
    }

    void preorder(TreeNode node) {
        if(node != null) {
            stack.push(node);

            if(node.left == null && node.right == null) {
                paths.add(printPath());
            }

            preorder(node.left);
            preorder(node.right);
            stack.pop();
        }
    }

    String printPath() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<stack.size(); i++) {
            sb.append(stack.get(i).val);

            if(i < stack.size()-1) {
                sb.append("->");
            }
        }

        return sb.toString();
    }
}
