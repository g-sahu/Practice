package com.practice.leetcode;

/*
1823. Find the Winner of the Circular Game
 */
public class FindTheWinner {

    public static void main(String[] args) {
        FindTheWinner fiw = new FindTheWinner();
        System.out.println(fiw.findTheWinner(6, 5));
    }

    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return n;
        }

        CircularLinkedList cll = new CircularLinkedList();
        cll.create(n);
        ListNode current = cll.head;

        while (cll.size > 1) {
            for (int i = 1; i < k; i++) {
                current = current.next;
            }

            ListNode temp = current;
            current = current.next;
            cll.delete(temp.val);
        }

        return cll.head.val;
    }
}

class CircularLinkedList {
    ListNode head;
    int size;
    CircularLinkedList() {}

    void create(int n) {
        size = n;
        head = new ListNode(1);
        ListNode current = head;

        for (int i = 2; i <= n; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }

        current.next = head;
    }

    void delete(int val) {
        if (head.next.val == head.val) {
            head = null;
        } else {
            if (head.val == val) {
                head = head.next;
            }

            ListNode current = head;

            while (current.next.val != val) {
                current = current.next;
            }

            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = null;
        }

        size--;
    }
}
