package com.practice.datastructures.linkedlists;

public class SinglyLinkedList {
    private int size;
    public Node head;

    public void add(int data) {
        Node node = new Node(data);
        Node temp = head;

        if(size > 0) {
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        } else {
            head = node;
        }

        size++;
    }

    public void delete(int data) {
        if(size > 0) {
            Node temp = head;
            Node node = null;

            if(temp.data != data) {
                while(temp.next != null) {
                    if(temp.next.data == data) {
                        node = temp;
                        break;
                    } else {
                        temp = temp.next;
                    }
                }

                if(temp != null && temp.next != null) {
                    if(temp.next.next != null) {
                        temp = temp.next.next;
                        node.next.next = null;
                        node.next = temp;
                    } else {
                        node.next = null;
                    }

                    size--;
                } else {
                    System.out.println("Node not found!");
                }
            } else {
                head = temp.next;
                temp.next = null;
            }
        } else {
            System.out.println("Linked list is empty!");
        }
    }

    public void printLinkedList() {
        if(size > 0) {
            Node temp = head;

            while(temp != null) {
                System.out.print(temp.data);

                if(temp.next != null) {
                    System.out.print("-->");
                }

                temp = temp.next;
            }
        }
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}