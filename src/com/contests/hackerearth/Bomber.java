package com.contests.hackerearth;

public class Bomber {

	public static void main(String[] args) {
		String str = "adbccccbbbdd"; 
		bomb(str);	
	}
	
	static void bomb(String str) {
		int l = str.length();

		while(l > 3) {
			int c = 1, j;

			for(int i=0; i<l; i++) {
				j = i + 1;

				while(compare(str.charAt(i), str.charAt(j))) {
					j++;
					c++;        
				}

				if(c >= 3) {
					if(i > 0) {
						str = str.substring(0, i) + str.substring(j, l);
					} else {
						str = str.substring(j, l+1);
					}

					break;
				}
			}

			l = str.length(); 
		}
		
		System.out.print(str);
	}
	
	static boolean compare(char a, char b) {
		return (a == b);
	}

}
