package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 */
public class WordPattern {

    public boolean wordPattern(String p, String s) {
        String[] w = s.split(" ");

        if(p.length() != w.length) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for(int i=0; i<p.length(); i++) {
            char ch = p.charAt(i);

            if(map1.containsKey(ch)) {
                if(!map1.get(ch).equals(w[i])) {
                    return false;
                }
            } else if(map2.containsKey(w[i])) {
                if(!map2.get(w[i]).equals(ch)) {
                    return false;
                }
            } else {
                map1.put(ch, w[i]);
                map2.put(w[i], ch);
            }
        }

        return true;
    }
}
