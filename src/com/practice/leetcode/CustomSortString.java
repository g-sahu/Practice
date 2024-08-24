package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 791. Custom Sort String
 */
public class CustomSortString {

    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int f = map.getOrDefault(ch, 0);
            map.put(ch, f+1);
        }

        for(int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            int f = map.getOrDefault(ch, 0);

            while(f-- > 0) {
                sb.append(ch);
            }

            map.remove(ch);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            char ch = entry.getKey();
            int f = map.getOrDefault(ch, 0);

            while(f-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
