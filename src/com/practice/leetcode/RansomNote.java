package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
383. Ransom Note
 */
public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "abcdabcde";
        RansomNote o = new RansomNote();
        System.out.println(o.canConstruct2(ransomNote, magazine));
    }

    //Using HashMap
    public boolean canConstruct1(String ransomNote, String magazine) {
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

    //Using frequency array
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            int j = magazine.charAt(i) - 'a';
            freq[j]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int j = ransomNote.charAt(i) - 'a';
            if (freq[j]-- == 0) {
                return false;
            }
        }

        return true;
    }
}
