package com.interviews.atlassian;

import java.util.HashMap;
import java.util.Map;

/*
    You are running a classroom and suspect that some of your students are passing around the answer
    to a multiple-choice question disguised as a random note.
    Your task is to write a function that, given a list of words and a note,
    finds and returns the word in the list that is scrambled inside the note, if any exists.
    If none exist, it returns the result "-" as a string.
    There will be at most one matching word.
    The letters don't need to be in order or next to each other.
    The letters cannot be reused.

    Example:
    words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"]
    note1 = "ctay"
    find(words, note1) => "cat"   (the letters do not have to be in order)

    note2 = "bcanihjsrrrferet"
    find(words, note2) => "cat"   (the letters do not have to be together)

    note3 = "tbaykkjlga"
    find(words, note3) => "-"     (the letters cannot be reused)

    note4 = "bbbblkkjbaby"
    find(words, note4) => "baby"

    note5 = "dad"
    find(words, note5) => "-"

    note6 = "breadmaking"
    find(words, note6) => "bird"

    note7 = "dadaa"
    find(words, note7) => "dada"

    All Test Cases:
    find(words, note1) -> "cat"
    find(words, note2) -> "cat"
    find(words, note3) -> "-"
    find(words, note4) -> "baby"
    find(words, note5) -> "-"
    find(words, note6) -> "bird"
    find(words, note7) -> "dada"

    Complexity analysis variables:

    W = number of words in `words`
    S = maximal length of each word or of the note
*/
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
