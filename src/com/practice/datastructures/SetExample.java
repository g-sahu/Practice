package com.practice.datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
        Set<Integer> a = new HashSet<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        
        Set<Integer> b = new HashSet<Integer>();
        b.add(4);
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
        
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        
        System.out.println("Union: " + union(a, b));
        System.out.println("Intersection: " + intersection(a, b));
        System.out.println("A-B: " + diffAB(a, b));
        System.out.println("B-A: " + diffBA(a, b));
	}
	
	static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
		Set<Integer> union = new HashSet<Integer>(a);
		Iterator<Integer> itr = b.iterator();
		Integer x;
		
		while(itr.hasNext()) {
			x = itr.next();
			
			if(!union.contains(x)) {
				union.add(x);
			}
		}
		
		return union;
	}
	
	static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
		Set<Integer> intersection = new HashSet<Integer>();
		Iterator<Integer> itr = a.iterator();
		Integer x;
		
		while(itr.hasNext()) {
			x = itr.next();
			
			if(b.contains(x)) {
				intersection.add(x);
			}
		}
		
		return intersection;
	}
	
	static Set<Integer> diffAB(Set<Integer> a, Set<Integer> b) {
		Set<Integer> diffAB = new HashSet<Integer>();
		Iterator<Integer> itr = a.iterator();
		Integer x;
		
		while(itr.hasNext()) {
			x = itr.next();
			
			if(!b.contains(x)) {
				diffAB.add(x);
			}
		}
		
		return diffAB;
	}
	
	static Set<Integer> diffBA(Set<Integer> a, Set<Integer> b) {
		Set<Integer> diffBA = new HashSet<Integer>();
		Iterator<Integer> itr = b.iterator();
		Integer x;
		
		while(itr.hasNext()) {
			x = itr.next();
			
			if(!a.contains(x)) {
				diffBA.add(x);
			}
		}
		
		return diffBA;
	}

}
