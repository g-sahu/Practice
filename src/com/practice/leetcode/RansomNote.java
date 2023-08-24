package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
383. Ransom Note
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            if (map.containsKey(ch)) {
                int freq = map.get(ch) - 1;
                if (freq == 0) {
                    map.remove(ch);
                } else {
                    map.replace(ch, freq);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
