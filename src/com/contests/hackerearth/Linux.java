package com.contests.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Linux {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> queries = new ArrayList<String>();
		ArrayList<String> dirs = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		String split[];
		final String ROOT = "/";
		StringBuffer path;
		String qr, parent, dir;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<n; i++) {
			split = br.readLine().split(" ");			
			map.put(split[1], split[0]);
		}
		
		int q = Integer.parseInt(br.readLine());
		
		for(int k=0; k<q; k++) {
			queries.add(br.readLine());
		}
		
		Iterator<String> itr = queries.iterator();
		
		while(itr.hasNext()) {
			path = new StringBuffer();
			dirs.clear();
			qr = itr.next();
			parent = map.get(qr); 
			
			while(parent != null) {
				dirs.add(parent);
				parent = map.get(parent);
			}
			
			if(!dirs.isEmpty()) {
				for(int x=dirs.size()-1; x>=0; x--) {
					dir = dirs.get(x);
					
					if(dir.equals("root")) {
						path = path.append(ROOT);
					} else {
						path = path.append(dir+"/");
					}
				}
				
				System.out.println(path);
			} else if(qr.equals("root")) {
				System.out.println(ROOT);
			} else {
				System.out.println("No such file or directory!");
			}
		}
	}

}
