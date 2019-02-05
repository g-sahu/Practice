package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MaximalConnection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int i, u, v;
		
		ArrayList<City> citiesList = new ArrayList<>();
		ArrayList<Integer> connectedTo;
		
		for(i=0; i<n; i++) {
			citiesList.add(new City());
		}
		
		for(i=0; i<m; i++) {
			citiesList.get(sc.nextInt() - 1).setSpecial(true);
		}
		
		for(i=0; i<x; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			
			citiesList.get(u-1).getConnectedTo().add(v-1);
		}
		
		sc.close();
		Iterator<City> itr = citiesList.iterator();
		int p = 0;
		
		while(itr.hasNext()) {
			connectedTo = itr.next().getConnectedTo();
			Iterator<Integer> itr1 = connectedTo.iterator();
			
			while(itr1.hasNext()) {
				City city = citiesList.get(itr1.next());
				
				if(city.isSpecial()) {
					p++;
				}
			}
		}
		
		System.out.println(p);

	}

}

class City {
	private boolean isSpecial;
	private ArrayList<Integer> connectedTo = new ArrayList<>();
	
	public boolean isSpecial() {
		return isSpecial;
	}
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
	public ArrayList<Integer> getConnectedTo() {
		return connectedTo;
	}
	public void setConnectedTo(ArrayList<Integer> connectedTo) {
		this.connectedTo = connectedTo;
	}
}
