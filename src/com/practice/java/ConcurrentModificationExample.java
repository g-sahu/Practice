package com.practice.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConcurrentModificationExample {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			Integer i = itr.next();
			
			if(i.equals(1)) {
				set.remove(i);
			}
		}
		
		/*for(Integer i: set) {
			if(i.equals(1)) {
				set.remove(i);
			}
		}*/
		
		System.out.println(set.toString());
	}

}
