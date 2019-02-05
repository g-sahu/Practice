package com.contests.hackerearth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberChecker {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        /*final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }*/

        String res;
        int numberArray_size = 0;
        numberArray_size = Integer.parseInt(in.nextLine().trim());
        int[] numberArray = new int[numberArray_size];
        
        for(int i = 0; i < numberArray_size; i++) {
            int numberArray_item;
            numberArray_item = Integer.parseInt(in.nextLine().trim());
            numberArray[i] = numberArray_item;
        }

        res = findQualifiedNumbers(numberArray);
        System.out.println(res);
        /*bw.write(res);
        bw.newLine();
        bw.close();*/
        in.close();
	}
	
	static String findQualifiedNumbers(int[] numberArray) {
		int l = numberArray.length;
		String split[];
		int num;
		boolean flag[] = new boolean[3];
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=0; i<l; i++) {
			split = String.valueOf(numberArray[i]).split("");
			flag[0] = false;
			flag[1] = false;
			flag[2] = false;
			
			for(int j=0; j<split.length; j++) {
				num = Integer.parseInt(split[j]);

				if(flag[0] != true && num == 1) {
					flag[0] = true;
				} else if(flag[1] != true && num == 2) {
					flag[1] = true;
				} else if(flag[2] != true && num == 3) {
					flag[2] = true;
				}

				if(flag[0] == true && flag[1] == true && flag[2] == true) {
					res.add(numberArray[i]);
					break;
				}
			}
		}
		
		if(res.isEmpty()) {
			return "-1";
		} else {
			Collections.sort(res);
			return res.toString().replace("[", "").replace("]", "").replace(" ", "");
		}
    }

}
