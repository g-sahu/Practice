package com.practice.datastructures.trees;

import static com.practice.datastructures.trees.BTreePrinter.printNode;

public class BSTExample {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(32);
        bst.addNode(20);
        bst.addNode(40);
        bst.addNode(7);
        bst.addNode(25);
        bst.addNode(35);
        bst.addNode(42);
        bst.addNode(18);
        printNode(bst.root);
    }
}
