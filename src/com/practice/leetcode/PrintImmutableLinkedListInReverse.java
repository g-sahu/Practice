package com.practice.leetcode;

import java.util.Stack;

/**
 * 1265. Print Immutable Linked List in Reverse
 */

interface ImmutableListNode {
    void printValue(); // print the value of this node.
    ImmutableListNode getNext(); // return the next node.
}

public class PrintImmutableLinkedListInReverse {

    //Using recursion
    public void printLinkedListInReverse1(ImmutableListNode head) {
        if(head != null) {
            printLinkedListInReverse1(head.getNext());
            head.printValue();
        }
    }

    //Using Stack
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        ImmutableListNode temp = head;

        while(temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }

        while(!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }
}
