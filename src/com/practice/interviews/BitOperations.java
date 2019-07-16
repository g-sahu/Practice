package com.practice.interviews;

import static java.lang.Integer.toBinaryString;

public class BitOperations {
    public static void main(String[] args) {
    	/*System.out.println("Max integer value: " + Integer.MAX_VALUE);
    	long max = Integer.MAX_VALUE; 
    	long l = max + max;
    	int intMax = Integer.MAX_VALUE + Integer.MAX_VALUE;
    	System.out.println("Max integer value + Max integer value (in long): " + (l/2));
    	System.out.println("Max integer value + Max integer value (in int): " + intMax);
    	System.out.println("Using >>> operator: " + (intMax >>> 1));*/
    	
    	/*Pattern ref = Pattern.compile(".*sit2-hix.wellpoint.com.*");
    	System.out.println(ref.matcher("https://sit2-hix.wellpoint.com/epe/saveHealthHistoryList.htm?apply=false").matches());*/
    	
    	int x = -3, y = 1;
    	
    	/*System.out.println("x = " + x + ", y = " + y);
    	x = x ^ y;
    	System.out.println("x = " + x + ", y = " + y);
    	y = x ^ y;
    	System.out.println("x = " + x + ", y = " + y);
    	x = x ^ y;
    	System.out.println("x = " + x + ", y = " + y);*/

		//System.out.println(x + " << " + y + " = " + (x << y));

        System.out.println(x + " in Binary =  " + toBinaryString(x));

        System.out.println(x + " >> 1 = " + (x >> 1));
        System.out.println(x + " >> 1 in Binary = " + toBinaryString((x >>> 1)));

        System.out.println(x + " >>> 1 = " + (x >>> 1));
        System.out.println(x + " >>> 1 in Binary = " + toBinaryString((x >>> 1)));

        System.out.println("Max integer = " +  Integer.MAX_VALUE);
    }
}