package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int n = Integer.parseInt(br.readLine());
			int res = n;

			while (n > 1) {
				res = res * (--n);
			}

			System.out.println("Factorial: " + res);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
    }
}
