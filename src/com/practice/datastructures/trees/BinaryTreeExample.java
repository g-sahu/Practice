package com.practice.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.practice.datastructures.trees.BTreePrinter.printNode;
import static com.practice.datastructures.trees.BinaryTree.Position.LEFT;
import static com.practice.datastructures.trees.BinaryTree.Position.RIGHT;

public class BinaryTreeExample {

    public static void main(String[] args) {
        BinaryTreeExample btExample = new BinaryTreeExample();
        BinaryTree bt = new BinaryTree(1);
        bt.addNode(bt.root, new Node(2), LEFT);
        bt.addNode(bt.root, new Node(3), RIGHT);
        bt.addNode(bt.root.left, new Node(4), LEFT);
        bt.addNode(bt.root.left, new Node(5), RIGHT);
        bt.addNode(bt.root.right, new Node(6), LEFT);
        bt.addNode(bt.root.right, new Node(7), RIGHT);

        printNode(bt.root);

		/*System.out.println();
		System.out.print("Level order: ");
		btExample.printLevelOrder(root);
		
		System.out.println();
		System.out.print("Spiral Level order: ");
		btExample.printSpiralOrder(root);*/
    }

    private void printInorderRecursive(Node root) {
        if (root != null) {
            printInorderRecursive(root.left);
            System.out.print(root.data + " ");
            printInorderRecursive(root.right);
        }
    }

    private void printInorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        if (root == null) {
            return;
        }

        /*
            Traverse the left sub-tree and
            push the nodes in the path that are waiting to be visited in a stack
        */
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        //Traverse the tree
        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right == null) {
                continue;
            }

            node = node.right;

            //Traverse the left sub-tree and
            //push the nodes in the path that are waiting to be visited in a stack
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    private void printPreorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printPreorderRecursive(root.left);
            printPreorderRecursive(root.right);
        }
    }

    private void printPreorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        if(root != null) {
            //Traverse the left sub-tree and
            //push the nodes in the path that are waiting to be visited in a stack
            while (node != null) {
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.left;
            }

            //Pop nodes from the stack
            while (stack.size() > 0) {
                node = stack.pop();

                if (node.right != null) {
                    node = node.right;

                    //Traverse the left sub-tree and
                    //push the nodes in the path that are waiting to be visited in a stack
                    while (node != null) {
                        System.out.print(node.data + " ");
                        stack.push(node);
                        node = node.left;
                    }
                }
            }
        }
    }

    private void printPostorderRecursive(Node root) {
        if (root != null) {
            printPostorderRecursive(root.left);
            printPostorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void printPostorderIterative(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if(root != null) {
            s1.push(root);

            // Run while first stack is not empty
            while (!s1.isEmpty()) {
                //Pop an item from s1 and push it to s2
                Node temp = s1.pop();
                s2.push(temp);

                // Push left and right children of removed item to s1
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }

            // Print all elements of second stack
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                System.out.print(temp.data + " ");
            }
        }
    }

    private void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

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

    private void printSpiralOrder(Node root) {
        if(root != null) {
            // Create two stacks to store alternate levels
            Stack<Node> s1 = new Stack<>();		// For levels to be printed from right to left
            Stack<Node> s2 = new Stack<>();		// For levels to be printed from left to right

            // Push first level to first stack 's1'
            s1.push(root);

            // Keep ptinting while any of the stacks has some nodes
            while(!s1.empty() || !s2.empty()) {
                // Print nodes of current level from s1 and push nodes of next level to s2
                while(!s1.empty()) {
                    Node temp = s1.peek();
                    s1.pop();
                    System.out.print(temp.data + " ");

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
                    Node temp = s2.peek();
                    s2.pop();
                    System.out.print(temp.data + " ");

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

	 /*private Node findLca(char n1, char n2) {
		 return findLca(root, n1, n2);
	 }*/

    private Node findLca(Node node, char n1, char n2) {
        // Exit criteria
        if (node == null)
            return null;

        // If any of the two nodes is found, return it
        if (node.data == n1 || node.data == n2)
            return node;

        // Look for keys in left and right subtrees
        Node leftLca = findLca(node.left, n1, n2);
        Node rightLca = findLca(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if (leftLca != null && rightLca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (leftLca != null) ? leftLca : rightLca;
    }

    private int findDistance(Node root, char a, char b) {
        Node lca = findLca(root, a , b);
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);
        return d1 + d2;
    }

    private int findLevel(Node root, int k, int level) {
        if(root == null) {
            return -1;
        }

        if(root.data == k) {
            return level;
        }

        int left = findLevel(root.left, k, level+1);

        if (left == -1) {
            return findLevel(root.right, k, level + 1);
        }

        return left;
    }
}
