package com.practice.dp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NewClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> superSet = new ArrayList<>();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			superSet.add(sc.nextInt());
		}

		int k = sc.nextInt();
		sc.close();
		List<Set<Integer>> list = getSubsets(superSet, k);

		for (Set<Integer> integers : list) {
			System.out.println(integers);
		}
	}

	private static void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current, List<Set<Integer>> solution) {
		//successful stop clause
		if (current.size() == k) {
			solution.add(new LinkedHashSet<>(current));
			return;
		}

		//unsuccessful stop clause
		if (idx == superSet.size()) {
			return;
		}

		Integer x = superSet.get(idx);
		current.add(x);

		//"guess" x is in the subset
		getSubsets(superSet, k, idx + 1, current, solution);
		current.remove(x);

		//"guess" x is not in the subset
		getSubsets(superSet, k, idx + 1, current, solution);
	}

	public static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
	    List<Set<Integer>> res = new ArrayList<>();
	    getSubsets(superSet, k, 0, new LinkedHashSet<>(), res);
	    return res;
	}
}
