package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/*
1305. All Elements in Two Binary Search Trees
 */
public class ElementsInBST {
    private final List<Integer> list = new ArrayList<>();

    //Using a list
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        collectNodes(root1);
        collectNodes(root2);
        Collections.sort(list);
        return list;
    }

    private void collectNodes(TreeNode node) {
        if (node != null) {
            collectNodes(node.left);
            list.add(node.val);
            collectNodes(node.right);
        }
    }

    //Using two queues
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        collectNodes(root1, q1);
        collectNodes(root2, q2);

        //Merge the queues
        while (!q1.isEmpty() || !q2.isEmpty()) {
            Integer num1 = q1.peek();
            Integer num2 = q2.peek();

            if (num1 == null) {
                list.add(q2.poll());
            }
            else if (num2 == null) {
                list.add(q1.poll());
            }
            else if (num1 < num2) {
                list.add(q1.poll());
            }
            else if (num2 < num1){
                list.add(q2.poll());
            }
            else {
                list.add(q1.poll());
                list.add(q2.poll());
            }
        }

        return list;
    }

    private void collectNodes(TreeNode node, Queue<Integer> queue) {
        if (node != null) {
            collectNodes(node.left, queue);
            queue.add(node.val);
            collectNodes(node.right, queue);
        }
    }
}
