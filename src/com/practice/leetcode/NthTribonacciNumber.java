package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
1137. N-th Tribonacci Number
 */
public class NthTribonacciNumber {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }

        int t = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        map.put(n, t);
        return t;
    }
}
