package com.practice.datastructures.trees;

class BinaryTree {
    Node root;

    BinaryTree(int root) {
        this.root = new Node(root);
    }

    void addNode(Node parent, Node child, Position position) {
        switch (position) {
            case LEFT:
                insertLeftChild(parent, child);
                break;
            case RIGHT:
                insertRightChild(parent, child);
                break;

        }
    }

    private void insertLeftChild(Node parent, Node child) {
        parent.left = child;
    }

    private void insertRightChild(Node parent, Node child) {
        parent.right = child;
    }

    enum Position { LEFT, RIGHT }
}
