package com.practice.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private static TreeNode root;

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		root = new TreeNode('A');

		bt.insertLeftChild(root, new TreeNode('B'));
		bt.insertRightChild(root, new TreeNode('C'));

		bt.insertLeftChild(root.left, new TreeNode('D'));
		bt.insertRightChild(root.left, new TreeNode('E'));

		bt.insertLeftChild(root.right, new TreeNode('F'));
		bt.insertRightChild(root.right, new TreeNode('G'));

		/*bt.insertLeftChild(root.left.left, new TreeNode('H'));
		bt.insertRightChild(root.left.left, new TreeNode('I'));*/

		/*System.out.print("Inorder with recursion: ");
		bt.printInorderRecursive(root);
		System.out.println();
		System.out.print("Inorder with iteration: ");
		bt.printInorderIterative(root);
		System.out.println();

		System.out.println();
		System.out.print("Preorder with recursion: ");
		bt.printPreorderRecursive(root);
		System.out.println();
		System.out.print("Preorder with iteration: ");
		bt.printPreorderIterative(root);
		System.out.println();

		System.out.println();
		System.out.print("Postorder with recursion: ");
		bt.printPostorderRecursive(root);
		System.out.println();
		System.out.print("Postorder with iteration: ");
		bt.printPostorderIterative(root);
		System.out.println();*/

		System.out.println();
		System.out.print("Level order: ");
		bt.printLevelOrder(root);
		
		System.out.println();
		System.out.print("Spiral Level order: ");
		bt.printSpiralOrder(root);

		/*System.out.println();
		System.out.print("LCA(D, G): ");
		System.out.println(bt.findLCA('D', 'G').data);

		System.out.print("Distance between D and G: ");
		System.out.println(bt.findDistance(root, 'D', 'G'));*/
	}

	void insertLeftChild(TreeNode root, TreeNode child) {
		root.left = child;
	}

	void insertRightChild(TreeNode root, TreeNode child) {
		root.right = child;
	}

	void deleteLeftChild(TreeNode root) {
		root.left = null;
	}

	void deleteRightChild(TreeNode root) {
		root.right = null;
	}

	void printInorderRecursive(TreeNode root) {
		if (root != null) {
			printInorderRecursive(root.left);
			System.out.print(root.data + " ");
			printInorderRecursive(root.right);
		}
	}
	
	void printInorderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

		if(root != null) {
			//Traverse the left sub-tree and 
			//push the nodes in the path that are waiting to be visited in a stack
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			//Traverse the tree
			while (stack.size() > 0) {
				node = stack.pop();
				System.out.print(node.data + " ");
				
				if (node.right != null) {
					node = node.right;

					//Traverse the left sub-tree and 
					//push the nodes in the path that are waiting to be visited in a stack
					while (node != null) {
						stack.push(node);
						node = node.left;
					}
				}
			}
		}
	}

	void printPreorderRecursive(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printPreorderRecursive(root.left);
			printPreorderRecursive(root.right);
		}
	}
	
	void printPreorderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

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

	void printPostorderRecursive(TreeNode root) {
		if (root != null) {
			printPostorderRecursive(root.left);
			printPostorderRecursive(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	void printPostorderIterative(TreeNode root) {
		// Create two stacks
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		if(root != null) {
			//Push root to first stack
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
				System.out.print(temp.data + " ");
			}
		}
	}

	void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			//Enqueue left child
			if(tempNode.left != null) {
				queue.add(tempNode.left);
			}

			//Enqueue right child
			if(tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
	
	void printSpiralOrder(TreeNode root) {
		if(root != null) { 
			// Create two stacks to store alternate levels
			Stack<TreeNode> s1 = new Stack<TreeNode>();		// For levels to be printed from right to left
			Stack<TreeNode> s2 = new Stack<TreeNode>();		// For levels to be printed from left to right

			// Push first level to first stack 's1'
			s1.push(root);

			// Keep ptinting while any of the stacks has some nodes
			while(!s1.empty() || !s2.empty()) {
				// Print nodes of current level from s1 and push nodes of next level to s2
				while(!s1.empty()) {
					TreeNode temp = s1.peek();
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
					TreeNode temp = s2.peek();
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

	 /**
	  * Find Lowest Common Ancestor of two nodes in Binary Tree
	  */
	 TreeNode findLCA(char n1, char n2) {
		 return findLCA(root, n1, n2);
	 }

	 /**
	  * Find Lowest Common Ancestor of two nodes in Binary Tree
	  */
	 TreeNode findLCA(TreeNode node, char n1, char n2) {
		 // Exit criteria
		 if (node == null)
			 return null;

		 // If any of the two nodes is found, return it
		 if (node.data == n1 || node.data == n2)
			 return node;

		 // Look for keys in left and right subtrees
		 TreeNode left_lca = findLCA(node.left, n1, n2);
		 TreeNode right_lca = findLCA(node.right, n1, n2);

		 // If both of the above calls return Non-NULL, then one key
		// is present in one subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	/**
	 * Find distance between two nodes of a tree.
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
	int findDistance(TreeNode root, char a, char b) {
		TreeNode lca = findLCA(root, a , b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}

	/**
	 * Returns level of key k if it is present in tree, otherwise returns -1
	 * @param root
	 * @param k
	 * @param level
	 * @return
	 */
	int findLevel(TreeNode root, int k, int level) {
		if(root == null) 
			return -1;

		if(root.data == k) 
			return level;

		int left = findLevel(root.left, k, level+1);

		if (left == -1)
			return findLevel(root.right, k, level+1);

		return left;
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	char data;

	TreeNode(char newData) {
		data = newData;
	}
}

