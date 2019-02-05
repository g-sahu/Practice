package com.practice.interviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
	    public static Map<String, Integer> processData(ArrayList<String> array) {
	        /* 
	         * Modify this method to process `array` as indicated
	         * in the question. At the end, return the appropriate value.
	         *
	         * Please create appropriate classes, and use appropriate
	         * data structures as necessary.
	         *
	         * Do not print anything in this method.
	         *
	         * Submit this entire program (not just this method)
	         * as your answer
	         */
	        Map<String, Integer> retVal = new HashMap<String, Integer>();
	        Map<String, Integer> map = new HashMap<String, Integer>();
	        int max = 0, id, marks;
	        String line, sub;
	        String split[];
	        
	        Iterator<String> itr = array.iterator();
	        
	        while(itr.hasNext()) {
	        	line = itr.next();
	        	split = line.split("\\|");
	        	
	        	id = Integer.parseInt(split[0]);
	        	sub = split[1];
	        	marks = Integer.parseInt(split[2]);
	        	
	        	if(map.containsKey(sub)) {
	        		max = map.get(sub);
	        	}
	        	
	        	if(marks > max) {
	        		map.put(sub, marks);
	        		retVal.put(sub, id);
	        	}
	        }
	        
	       return retVal;
	    }

	    public static void main (String[] args) {
	        ArrayList<String> inputData = new ArrayList<String>();
	        String line;
	        
	        try {
	            Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Data\\input.txt")));
	            
	            while(in.hasNextLine()) {
	                inputData.add(in.nextLine());
	            }
	            
	            Map<String, Integer> retVal = processData(inputData);
	            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Data\\output.txt")));
	            
	            for(Map.Entry<String,Integer> e: retVal.entrySet()) {
	                output.println(e.getKey() + ": " + e.getValue());
	            }
	            
	            output.close();
	            in.close();
	        } catch (IOException e) {
	            System.out.println("IO error in input.txt or output.txt");
	        }
	    }
}
