package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeCase {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			int i = 0;

			for (Character c : arr) {
				if (Character.isLowerCase(c)) {
					arr[i] = (char) (c - 32);
				} else if (Character.isUpperCase(c)) {
					arr[i] = (char) (c + 32);
				}

				System.out.print(arr[i]);
				i++;
			}
		} catch (IOException ioe) {

		}
	}
}
