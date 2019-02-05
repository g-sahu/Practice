package com.practice.interviews;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LinkedListImpl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Length of linked list: ");
		int n = sc.nextInt();
		MyLinkedList list1 = new MyLinkedList();
		
		for(int i=0; i<n; i++) {
			list1.add(sc.nextInt());
		}
		
		sc.close();
		
		list1.printLinkedList();
		System.out.println();
		
		list1.head = increment(list1.head);
		list1.printLinkedList();
		
		/*list1.head = reverse(list1.head);
		list1.printLinkedList();*/
		
		/*MyLinkedList list2 = new MyLinkedList();
		list2.add(3);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);
		
		list2.printLinkedList();
		System.out.println();*/
		
		//System.out.println(findNthNodeFromLast(list1.head, 3).data);
		
		/*LinkedNode head = merge(list1.head, list2.head);
		System.out.println();
		System.out.println("Linked List after merging: ");*/
		
		/*swapNodes(list1.head, 3, 7);
		System.out.println();
		System.out.println("List after swapping 3 and 7: ");
		list1.printLinkedList();*/
		
		/*createIntersection(list1.head, list2.head);
		System.out.println();
		System.out.println("Intersecting node: " + findIntersectingNode(list1.head, list2.head).data);*/
	}
	
	static LinkedNode merge(LinkedNode head1, LinkedNode head2) {
		LinkedNode newHead = null, temp1, temp2, tail = null;
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
	
	static LinkedNode findNthNodeFromLast(LinkedNode head, int N){
		LinkedNode front = head;
		LinkedNode rear = head;
		
		for(int i=1; i<N; i++) {
		    front = front.next;
		}
		
		while(front.next != null) {
		    front = front.next;
		    rear = rear.next;
		}
		
		return rear;
	}
	
	static LinkedNode swapNodes(LinkedNode head, int x, int y) {
		LinkedNode t = null, p1 = null, p2 = null;
		LinkedNode h = head;
		
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
	
	static void createIntersection(LinkedNode head1, LinkedNode head2) {
		while(head1.next != null) {
			head1 = head1.next;
		}
		
		head1.next = head2.next.next.next;
	}
	
	static LinkedNode findIntersectingNode(LinkedNode head1, LinkedNode head2) {
		Set<LinkedNode> set = new HashSet<LinkedNode>();
		
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
	
	/**
	 * Reverses the given LinkedList
	 * @param head
	 * @return
	 */
	private static LinkedNode reverse(LinkedNode head) {
		LinkedNode newHead = null, temp;
		
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
	private static LinkedNode increment(LinkedNode head) {
		LinkedNode temp1 = head, temp2 = null;
		
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
			LinkedNode node = new LinkedNode(1);
			node.next = temp2;
			head = node;
			
			while(temp2 != null) {
				temp2.data = 0;
				temp2 = temp2.next;
			}
		} else if (temp1 == head && temp1.data == 9) {
			LinkedNode node = new LinkedNode(1);
			node.next = temp1;
			head = node;
			temp1.data = 0;
		} else {
			temp1.data = temp1.data + 1;
		}
		
		return head;
	}
}

class MyLinkedList {
	private int size;
	LinkedNode head;

	public void add(int data) {
		LinkedNode node = new LinkedNode(data);
		LinkedNode temp = head; 
		
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
			LinkedNode temp = head;
			LinkedNode node = null;
			
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
			LinkedNode temp = head;

			while(temp != null) {
				System.out.print(temp.data);
				
				if(temp.next != null) {
					System.out.print("-->");
				}
				
				temp = temp.next;
			}
		}
	}
}

class LinkedNode {
	int data;
	LinkedNode next;
	
	LinkedNode(int data) {
		this.data = data;
	}
}