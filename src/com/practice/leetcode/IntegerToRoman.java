package com.practice.leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 12. Integer to Roman
 */
public class IntegerToRoman {
    private static final Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());

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

    public static void main(String[] args) {
        IntegerToRoman o = new IntegerToRoman();
        System.out.println(o.intToRoman(69));
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while(num != 0) {
            int d = map.containsKey(num) ? num : getDivisor(num);
            int q = num/d;
            sb.append(map.get(d).repeat(q));
            num = num%d;
        }

        return sb.toString();
    }

    private int getDivisor(int n) {
        for(int k: map.keySet()) {
            if(n > k) {
                return k;
            }
        }
        return -1;
    }
}
