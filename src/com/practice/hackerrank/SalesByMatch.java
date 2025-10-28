package com.practice.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesByMatch {

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int a: ar) {
            int f = map.getOrDefault(a, 0) + 1;
            map.put(a, f);
        }

        int c = 0;

        for(int v: map.values()) {
            c = c + (v/2);
        }

        return c;
    }
}
