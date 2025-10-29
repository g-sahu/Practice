package com.practice.hackerrank;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfABinaryTree {

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        int l = 0;

        while(!q.isEmpty()) {
            int n = q.size();
            l++;

            for(int i=1; i<=n; i++) {
                Node node = q.poll();

                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return l-1;
    }
}
