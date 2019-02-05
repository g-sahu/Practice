package com.contests.hackerearth;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimeDigitNumber {
	private final static boolean TRUE = true;
	private final static boolean FALSE = false;
	private final static int ZERO = 0;
	private final static BigInteger TWO = new BigInteger("2");
	private final static BigInteger FIVE = new BigInteger("5");
	private final static BigInteger SEVEN = new BigInteger("7");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger x = n;
		sc.close();

		while(TRUE) {
			if(isPrimeDigits(x)) {
				System.out.println(x);
				break;
			} else {
				x = x.subtract(BigInteger.ONE);
			}
		}
	}

	static boolean isPrimeDigits(BigInteger x) {
		boolean isPrimeDigits = FALSE;
		BigInteger q = x.divide(BigInteger.TEN); 
		BigInteger r = x.remainder(BigInteger.TEN);

		while(q.compareTo(BigInteger.ZERO) >= ZERO) {
			if(q.compareTo(BigInteger.ZERO) == ZERO) {
				if(isPrime(r)) {
					isPrimeDigits = TRUE;
				} else {
					isPrimeDigits = FALSE;
				}

				break;
			} else {
				if(isPrime(r)) {
					isPrimeDigits = TRUE;
				} else {
					isPrimeDigits = FALSE;
					break;
				}
			}

			r = q.remainder(BigInteger.TEN);
			q = q.divide(BigInteger.TEN);
		}

		return isPrimeDigits;
	}

	static boolean isPrime(BigInteger n) {		
		if(n.equals(TWO) || n.equals(FIVE) || n.equals(SEVEN)) {
			return TRUE;
		} else {
			return FALSE;
		}
	}
}
