package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MobileSelection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Phone> phoneList = new ArrayList<Phone>();
		List<Phone> custList = new ArrayList<Phone>();
		Phone phone;
		
		for(int i=0; i<n; i++) {
			phone = new Phone();
			phone.setOs(sc.next());
			phone.setRam(sc.nextInt());
			phone.setMemory(sc.nextInt());
			phone.setPrice(sc.nextInt());
			phone.setRating(sc.nextInt());
			phoneList.add(phone);
		}
		
		int q = sc.nextInt();
		
		for(int i=0; i<q; i++) {
			phone = new Phone();
			phone.setOs(sc.next());
			phone.setRam(sc.nextInt());
			phone.setMemory(sc.nextInt());
			phone.setPrice(sc.nextInt());
			custList.add(phone);
		}
		
		sc.close();
		Iterator<Phone> custListIterator = custList.iterator();
		int max = -1;
		
		while(custListIterator.hasNext()) {
			phone = custListIterator.next();
			max = -1;
			
			for(Phone ph: phoneList) {
				if(phone.equals(ph)) {
					max = ph.getRating() > max ? ph.getRating() : max; 
				}
			}
			
			System.out.println(max);
		}
	}
}

class Phone {
	private String os;
	private int ram;
	private int memory;
	private int price;
	private int rating;
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public boolean equals(Object obj) {
		Phone phone;
		
		if(obj instanceof Phone) {
			phone = (Phone) obj;
			
			if(phone.getOs().equals(this.getOs()) && 
				phone.getRam() == this.getRam() && 
				phone.getMemory() == this.getMemory() &&
				phone.getPrice() <= this.getPrice()) {
				return true;
			}
		}
		
		return false;
	}
}
