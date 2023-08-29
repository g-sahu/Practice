package com.practice.datastructures.trees;

import com.practice.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.practice.datastructures.trees.BTreePrinter.printNode;
import static com.practice.datastructures.trees.BinaryTree.Position.LEFT;
import static com.practice.datastructures.trees.BinaryTree.Position.RIGHT;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        BinaryTreeTraversal btExample = new BinaryTreeTraversal();
        BinaryTree bt = new BinaryTree(1);
        bt.addNode(bt.root, new TreeNode(2), LEFT);
        bt.addNode(bt.root, new TreeNode(3), RIGHT);
        bt.addNode(bt.root.left, new TreeNode(4), LEFT);
        bt.addNode(bt.root.left, new TreeNode(5), RIGHT);
        bt.addNode(bt.root.right, new TreeNode(6), LEFT);
        bt.addNode(bt.root.right, new TreeNode(7), RIGHT);
        printNode(bt.root);

		/*System.out.println();
		System.out.print("Level order: ");
		btExample.printLevelOrder(root);
		
		System.out.println();
		System.out.print("Spiral Level order: ");
		btExample.printSpiralOrder(root);*/
    }

    private void printInorderRecursive(TreeNode root) {
        if (root != null) {
            printInorderRecursive(root.left);
            System.out.print(root.val + " ");
            printInorderRecursive(root.right);
        }
    }

    private void printInorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        if (root == null) {
            return;
        }

        /*
            Traverse the left subtree and
            push the nodes in the path that are waiting to be visited in a stack
        */
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        //Traverse the tree
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val + " ");

            if (node.right == null) {
                continue;
            }

            node = node.right;

            //Traverse the left subtree and
            //push the nodes in the path that are waiting to be visited in a stack
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    private void printPreorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreorderRecursive(root.left);
            printPreorderRecursive(root.right);
        }
    }

    private void printPreorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        if(root != null) {
            //Traverse the left subtree and
            //push the nodes in the path that are waiting to be visited in a stack
            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }

            //Pop nodes from the stack
            while (!stack.isEmpty()) {
                node = stack.pop();

                if (node.right != null) {
                    node = node.right;

                    //Traverse the left subtree and
                    //push the nodes in the path that are waiting to be visited in a stack
                    while (node != null) {
                        System.out.print(node.val + " ");
                        stack.push(node);
                        node = node.left;
                    }
                }
            }
        }
    }

    private void printPostorderRecursive(TreeNode root) {
        if (root != null) {
            printPostorderRecursive(root.left);
            printPostorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }

    private void printPostorderIterative(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        if(root != null) {
            s1.push(root);

            // Run while first stack is not empty
            while (!s1.isEmpty()) {
                //Pop an item from s1 and push it to s2
                TreeNode temp = s1.pop();
                s2.push(temp);

                // Push left and right children of removed item to s1
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }

            // Print all elements of second stack
            while (!s2.isEmpty()) {
                TreeNode temp = s2.pop();
                System.out.print(temp.val + " ");
            }
        }
    }

    private void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            //Enqueue left child
            if(node.left != null) {
                queue.add(node.left);
            }

            //Enqueue right child
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private void printSpiralOrder(TreeNode root) {
        if(root != null) {
            // Create two stacks to store alternate levels
            Stack<TreeNode> s1 = new Stack<>();		// For levels to be printed from right to left
            Stack<TreeNode> s2 = new Stack<>();		// For levels to be printed from left to right

            // Push first level to first stack 's1'
            s1.push(root);

            // Keep printing while any of the stacks has some nodes
            while(!s1.empty() || !s2.empty()) {
                // Print nodes of current level from s1 and push nodes of next level to s2
                while(!s1.empty()) {
                    TreeNode temp = s1.peek();
                    s1.pop();
                    System.out.print(temp.val + " ");

                    // Note that right node is pushed before left
                    if(temp.right != null) {
                        s2.push(temp.right);
                    }

                    if(temp.left != null) {
                        s2.push(temp.left);
                    }
                }

                // Print nodes of current level from s2 and push nodes of next level to s1
                while(!s2.empty()) {
                    TreeNode temp = s2.peek();
                    s2.pop();
                    System.out.print(temp.val + " ");

                    // Note that is left is pushed before right
                    if(temp.left != null) {
                        s1.push(temp.left);
                    }

                    if(temp.right != null) {
                        s1.push(temp.right);
                    }
                }
            }
        }
    }

	 /*private TreeNode findLca(char n1, char n2) {
		 return findLca(root, n1, n2);
	 }*/

    private TreeNode findLca(TreeNode node, char n1, char n2) {
        // Exit criteria
        if (node == null)
            return null;

        // If any of the two nodes is found, return it
        if (node.val == n1 || node.val == n2)
            return node;

        // Look for keys in left and right subtrees
        TreeNode leftLca = findLca(node.left, n1, n2);
        TreeNode rightLca = findLca(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if (leftLca != null && rightLca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (leftLca != null) ? leftLca : rightLca;
    }

    private int findDistance(TreeNode root, char a, char b) {
        TreeNode lca = findLca(root, a , b);
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);
        return d1 + d2;
    }

    private int findLevel(TreeNode root, int k, int level) {
        if(root == null) {
            return -1;
        }

        if(root.val == k) {
            return level;
        }

        int left = findLevel(root.left, k, level+1);

        if (left == -1) {
            return findLevel(root.right, k, level + 1);
        }

        return left;
    }
}
