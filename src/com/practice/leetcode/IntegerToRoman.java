package com.practice.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 12. Integer to Roman
 */
public class IntegerToRoman {
    private static final Map<Integer, String> map = new TreeMap<>();

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while(num != 0) {
            int d = map.containsKey(num) ? num : getDivisor(num);
            int q = num/d;
            String s = map.get(d);

            for(int i=1; i<=q; i++) {
                sb.append(s);
            }

            num = num%d;
        }

        return sb.toString();
    }

    private int getDivisor(int n) {
        int d = 1;

        for(int k: map.keySet()) {
            if(n > k) {
                d = k;
            } else {
                return d;
            }
        }
        return d;
    }
}
