package com.practice.interviews;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class RecursiveLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of Linked List: ");
		int l = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		System.out.println("Enter the elements of Linked List- ");
		
		for(int i=0; i<l; i++) {
			list.add(sc.nextInt());
		}

		sc.close();
		printLinkedList(list);

	}
	
	static void printLinkedList(LinkedList<Integer> list) {
		Iterator<Integer> itr = list.iterator();
		int i = 1;
		
		while(itr.hasNext()) {
			if(i < list.size()) {
				System.out.print(itr.next() + " -> ");
			} else {
				System.out.print(itr.next());
			}
			i++;
		}
	}
	
	static void printRecursive() {
		
	}

}
