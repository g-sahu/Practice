package com.contests.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberPattern {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int res;
        String pattern;
        
        try {
            pattern = in.nextLine();
        } catch (Exception e) {
            pattern = null;
        }

        res = findPossibleSmallestNumberMatchingPattern(pattern);
        System.out.println(res);
        in.close();
	}
	
	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		char arr[] = pattern.toCharArray();
		List<Integer> list = new ArrayList<Integer>();
		Integer last = 0;
		int lastN = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 'M') {
				if(i == 0) {
					last = 2;
					list.add(last);
					list.add(--last);
				} else {
					while(list.contains(last)) {
						last--;
					}
					
					if(last > 0) {
						list.add(last);
						lastN = i;
					} else {
						for(int j=lastN; j<list.size(); j++) {
							last = list.get(j);
							list.set(j, last + 1);
						}
						
						list.add(last);
					}
				}
			} else if(arr[i] == 'N') {
				if(i == 0) {
					last = 1;
					list.add(last);
					list.add(++last);
					lastN = 1;
				} else {
					while(list.contains(last)) {
						last++;
					}

					list.add(last);
					lastN = i + 1;
				}
			} else {
				return -1;
			}
		}
		
		if(list.isEmpty()) {
			return -1;
		} else {
			String str = list.toString().replace("[", "").replace("]", "").replace(" ", "").replace(",", "");
			return Integer.parseInt(str);
		}
    }
}
