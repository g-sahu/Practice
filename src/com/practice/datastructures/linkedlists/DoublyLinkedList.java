package com.practice.datastructures.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public void add(int data) {
        Node node = new Node(data);

        if(head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void remove(int data) {
        Node temp = head;

        if(head == tail && temp.data == data) {
            head = null;
            tail = null;
        } else {
            while(temp != null) {
                if(temp.data == data) {
                    if(temp == head) {
                        head = temp.next;
                        head.prev = null;
                        temp.next = null;
                    } else if (temp == tail) {
                        tail = temp.prev;
                        tail.next = null;
                        temp.prev = null;
                    } else {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                        temp.prev = null;
                        temp.next = null;
                    }
                }

                temp = temp.next;
            }
        }
    }

    public void remove(Node node) {
        if(head == tail && node == head) {
            head = null;
            tail = null;
        } else {
            if(node == head) {
                head = node.next;
                head.prev = null;
                node.next = null;
            } else if (node == tail) {
                tail = node.prev;
                tail.next = null;
                node.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
        }
    }

    public void removeFirst() {
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            head = temp.next;
            head.prev = null;
            temp.next = null;
        }
    }

    public void removeLast() {
        if (tail == head) {
            head = null;
            tail = null;
        } else  {
            Node temp = tail;
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
        }
    }

    public Node getNode(int data) {
        Node temp = head;

        while(temp != null) {
            if(temp.data == data) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    public Integer getFirst() {
        return head != null ? head.data : null;
    }

    public Object[] toArray() {
        List<Integer> values = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            values.add(temp.data);
            temp = temp.next;
        }

        return values.toArray();
    }

    public static class Node {
        private Node prev;
        private Node next;
        private final int data;

        private Node(int data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }
    }
}
