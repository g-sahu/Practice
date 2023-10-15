package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfilePicture {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> output = new ArrayList<>();
		int l = sc.nextInt();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();

			if (w < l || h < l) {
				output.add("UPLOAD ANOTHER");
			} else if (w == h) {
				output.add("ACCEPTED");
			} else {
				output.add("CROP IT");
			}
		}

		sc.close();

        for (String s : output) {
            System.out.println(s);
        }
	}
}
