package com.interviews;

import java.util.ArrayList;
import java.util.Collections;

public class ThoughtWorksString {

	public static void main(String[] args) {
		String result = "";
	    int len1 = 0;
	    int len2 = 0;
	    int len3 = 0;
	    
	    String s1 = "chair";
	    String s2 = "mat";
	    String s3 = "phone";

	    ArrayList<Character> list = new ArrayList<>();

	    while (len1 != s1.length() || len2 != s2.length() || len3 != s3.length()) {
	    	if (len1 != s1.length()) {
	    		list.add(s1.charAt(len1));
	    		len1++;
	    	}
	    	
	    	if (len2 != s2.length()) {
	    		list.add(s2.charAt(len2));
	    		len2++;
	    	}
	    	
	    	if (len3 != s3.length()) {
	    		list.add(s3.charAt(len3));
	    		len3++;
	    	}
	    	
	    	Collections.sort(list);

	    	for(Character c : list)
	    		result = result + "" + c;

	    	list.clear();
	    }

	    System.out.println(result);
	}
}
