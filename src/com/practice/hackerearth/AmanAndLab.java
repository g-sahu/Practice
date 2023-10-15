package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AmanAndLab {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		List<Integer> dup;
		int t;

		for (int i = 1; i <= n; i++) {
			t = sc.nextInt() + sc.nextInt();
			list.add(t);

			if (map.containsKey(t)) {
				dup = map.get(t);
				dup.add(i);
				map.put(t, dup);
			} else {
				dup = new ArrayList<>();
				dup.add(i);
				map.put(t, dup);
			}
		}

		sc.close();
		Collections.sort(list);

        for (Integer integer : list) {
            dup = map.get(integer);

            if (dup.size() > 1) {
                Collections.sort(dup);
            }

            for (Integer i : dup) {
                System.out.print(i + " ");
            }
        }
	}

}
