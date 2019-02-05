package com.contests.hackerrank;

import java.io.IOException;

public class CurrencyArbitrage {

	public static void main(String[] args) throws IOException {
	}
	
	static int[] arbitrage(String[] quotes) {
		int l = quotes.length;
		int profit[] = new int[l];
		String quote = null;
		String rates[] = null;		
		double origAmount = 100000.00;
		double newAmount = 0.00;
		
		for(int i=0; i<l; i++) {
			quote = quotes[i];
			rates = quote.split(" ");
			newAmount = (int) (((origAmount / Double.parseDouble(rates[0])) / Double.parseDouble(rates[1])) / Double.parseDouble(rates[2]));
			profit[i] = newAmount > origAmount ? (int) (newAmount - origAmount) : 0;
		}
		
		return profit;
    }
}
