package com.interviews;

import java.util.Scanner;

public class NCR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n, p;
        NCR ncr = new NCR();
        
        while(sc.hasNext()) {
        	n = sc.nextInt();
        	p = sc.nextInt();
        	
        	try {
        		System.out.println(ncr.power(n, p));
        	} catch(Exception e) {
        		System.out.println(e.getClass().getName() + ": " + e.getMessage());
        	}
        }
        
        sc.close();
	}
	
	int power(int n, int p) throws Exception {
        if(n < 0 || p < 0) {
            throw new Exception("n and p should be non-negative");
        }
          
        return (p == 0) ? 1 : n*power(n,p-1);
    }

}
