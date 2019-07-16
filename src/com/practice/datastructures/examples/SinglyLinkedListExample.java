package com.practice.datastructures.examples;

import com.practice.datastructures.linkedlists.SinglyLinkedList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.practice.datastructures.linkedlists.SinglyLinkedList.Node;

public class SinglyLinkedListExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Length of linked list: ");
		int n = sc.nextInt();
		SinglyLinkedList list1 = new SinglyLinkedList();
		
		for(int i=0; i<n; i++) {
			list1.add(sc.nextInt());
		}
		
		sc.close();
		list1.printLinkedList();
		System.out.println();
		System.out.println();
		insertionSort(list1);
		System.out.println("After sorting: ");
		list1.printLinkedList();
	}
	
	static Node merge(Node head1, Node head2) {
		Node newHead = null, temp1, temp2, tail = null;
		temp1 = head1;
		temp2 = head2;
		
		while(temp1 != null && temp2 != null) {
			while(temp1.next != null && temp1.next.data < temp2.data) {
				temp1 = temp1.next;
			}

			//temp1 = head1.next;

			while(temp2.next != null && temp2.next.data < temp1.data) {
				temp2 = temp2.next;
			}

			if(newHead == null) {
				newHead = head1;
			}
		}
		
		return newHead;
	}
	
	static Node findNthNodeFromLast(Node head, int N){
		Node front = head;
		Node rear = head;
		
		for(int i=1; i<N; i++) {
		    front = front.next;
		}
		
		while(front.next != null) {
		    front = front.next;
		    rear = rear.next;
		}
		
		return rear;
	}
	
	static Node swapNodes(Node head, int x, int y) {
		Node t = null, p1 = null, p2 = null;
		Node h = head;
		
		while(h.next != null) { 
			if(h.next.data == x) {
				t = h;
				p1 = h.next;
			} else if(h.data == y) {
				p2 = h;
			}
			
			h = h.next;
		}
		
		t.next = p2;
		t = p2.next;
		p2.next = p1.next;
		p1.next.next = p1;
		p1.next = t;
		
		return head;
	}
	
	static void createIntersection(Node head1, Node head2) {
		while(head1.next != null) {
			head1 = head1.next;
		}
		
		head1.next = head2.next.next.next;
	}
	
	static Node findIntersectingNode(Node head1, Node head2) {
		Set<Node> set = new HashSet<Node>();
		
		while(head1 != null) {
			set.add(head1);
			head1 = head1.next;
		}
		
		while(head2 != null) {
			if(!set.add(head2)) {
				return head2;
			}
			
			head2 = head2.next;
		}
		
		return null;
	}

	private static Node reverse(Node head) {
		Node newHead = null, temp;
		
		while(head != null) {
			temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
			
		return newHead;
	}
	
	/**
	 * Increments the number represented by the linked list by 1
	 */
	private static Node increment(Node head) {
		Node temp1 = head, temp2 = null;
		
		while(temp1.next != null) {
			if(temp2 != null) {
				if(temp1.next.data != 9) {
					temp2 = null;
				}
			} else if(temp1.next.data == 9) {
				temp2 = temp1;
			}
			
			temp1 = temp1.next;
		}
		
		if(temp2 != null && temp2.data != 9) {
			temp2.data = temp2.data + 1;
			temp2 = temp2.next;

			while(temp2 != null) {
				temp2.data = 0;
				temp2 = temp2.next;
			}
		} else if (temp2 == head) {
			Node node = new Node(1);
			node.next = temp2;
			head = node;
			
			while(temp2 != null) {
				temp2.data = 0;
				temp2 = temp2.next;
			}
		} else if (temp1 == head && temp1.data == 9) {
			Node node = new Node(1);
			node.next = temp1;
			head = node;
			temp1.data = 0;
		} else {
			temp1.data = temp1.data + 1;
		}
		
		return head;
	}

	private static void insertionSort(SinglyLinkedList list) {
		if(list.head.next != null) {
			Node i = list.head.next;
			int temp;

			while(i != null) {
				Node j = list.head;

				while (j != i) {
					if(i.data < j.data) {
						temp = i.data;
						i.data = j.data;
						j.data = temp;
					}

					j = j.next;
				}

				i = i.next;
			}
		}
	}
}