package com.practice.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MagicalWord {

	public static void main(String[] args) {
		int t, l, j;
		String str;
		StringBuffer outStr;
		char[] arr;
		ArrayList<StringBuffer> list = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(br.readLine());

			if (t >= 1 && t <= 100) {
				for (int i = 0; i < t; i++) {
					l = Integer.parseInt(br.readLine());
					str = br.readLine();
					arr = str.toCharArray();
					outStr = new StringBuffer();
					j = 0;

					if (l >= 1 && l <= 500) {
						for (Character c : arr) {
							if (!isPrime(c)) {
								arr[j] = (char) getNearestMagical(c);
							}

							outStr.append(arr[j]);
							j++;
						}

						list.add(outStr);
					}
				}

                for (StringBuffer stringBuffer : list) {
                    System.out.println(stringBuffer);
                }
			}
		} catch (Exception e) {

		}

	}
	
	private static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
	
	private static int getNearestMagical(int n) {
		int i = n - 1;
		int j = n + 1;

		while (i >= 65) {
			if (isPrime(i)) {
				break;
			}

			if (i == 97) {
				i = 90;
			} else {
				i--;
			}
		}

		while (j <= 122) {
			if (isPrime(j)) {
				break;
			}

			if (j == 90) {
				j = 97;
			} else {
				j++;
			}
		}

		if (i < 65 && j <= 122) {
			return j;
		}

		if (i >= 65 && j > 122) {
			return i;
		}


		if ((n - i) < (j - n)) {
			return i;
		} else if ((n - i) > (j - n)) {
			return j;
		} else {
			return i;
		}
	}

}
