package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveFriends {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, k;
		Integer[] arr;
		ArrayList<Integer[]> outputList = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			k = sc.nextInt();

			arr = new Integer[n];

			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}

			removeFriend(arr, k);
			outputList.add(arr);
		}

		sc.close();

        for (Integer[] integers : outputList) {
            arr = integers;

            for (Integer i : arr) {
                if (i != -1) {
                    System.out.print(i + " ");
                }
            }

            System.out.println();
        }
	}
	
	static void removeFriend(Integer[] arr, int k) {
		boolean deleteFriend = false;
		int l = arr.length;
		int c = 0, j;
		
		while(c < k) {
			for(int i=0; i<l-1; i++) {
				j = i+1;
				
				while(j < l && arr[j] == -1) {
					j++;
				}
				
				if(arr[i] != -1 && arr[i] < arr[j] && c < k) {
					arr[i] = -1;
					deleteFriend = true;
					c++;
				}
			}
		}
		
		if(!deleteFriend) {
			int i = 0, x = 0;
			
			for(; i<l; i++) {
				if(arr[i] != -1) {
					x = i;
				}
			}
			
			if(i != l) {
				arr[x] = -1;
			}
		}
	}

}
