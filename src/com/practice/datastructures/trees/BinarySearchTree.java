package com.practice.datastructures.trees;

class BinarySearchTree {
    Node root;

    BinarySearchTree(int root) {
        this.root = new Node(root);
    }

    void addNode(int data) {
        Node temp = root;

        while(true) {
            if(data < temp.data) {
                if(temp.left == null) {
                    temp.left = new Node(data);
                    break;
                } else {
                    temp = temp.left;
                }
            } else if(data > temp.data) {
                if(temp.right == null) {
                    temp.right = new Node(data);
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                break;
            }
        }
    }
}
