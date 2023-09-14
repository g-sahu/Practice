package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
509. Fibonacci Number
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber fn = new FibonacciNumber();
        System.out.println(fn.fib2(6));
    }

    //DP: Top-down
    public int fib1(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        return fib(n, map);
    }

    public int fib(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        map.put(n, fib(n-1, map) + fib(n-2, map));
        return map.get(n);
    }

    //DP: Bottom-up
    public int fib2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);

        for (int i = 2; i <= n; i++) {
            int fib = map.get(i-1) + map.get(i-2);
            map.put(i, fib);
        }

        return map.get(n);
    }
}
