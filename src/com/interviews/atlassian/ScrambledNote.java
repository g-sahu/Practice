package com.interviews.atlassian;

import java.util.HashMap;
import java.util.Map;

public class ScrambledNote {
    private final String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
    private static final Map<String, Map<Character, Integer>> WORD_MAP = new HashMap<>();

    public static void main(String[] argv) {
        String[] notes = {"ctay", "bcanihjsrrrferet", "tbaykkjlga", "bbbblkkjbaby", "dad", "breadmaking", "dadaa"};
        ScrambledNote s = new ScrambledNote();

        for (String note: notes) {
            System.out.println(s.find(note));
        }
    }

    private String find(String note) {
        String res = "-";

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            Map<Character, Integer> map = buildMap(word);
            int l = note.length();

            if (l < word.length()) {
                continue;
            }

            for (int i = 0; i < l; i++) {
                char ch = note.charAt(i);

                if (map.containsKey(ch)) {
                    int newVal = map.get(ch) - 1;

                    if (newVal == 0) {
                        map.remove(ch);
                    } else {
                        map.put(ch, newVal);
                    }

                    sb.append(ch);
                }
            }

            if (sb.length() == word.length()) {
                res = word;
            }
        }

        return res;
    }

    private static Map<Character, Integer> buildMap(String word) {
        if (WORD_MAP.containsKey(word)) {
            return WORD_MAP.get(word);
        }

        int size = word.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<size; i++) {
            char c = word.charAt(i);
            int newVal = map.getOrDefault(c, 0) + 1;
            map.put(c, newVal);
        }
        return map;
    }
}
