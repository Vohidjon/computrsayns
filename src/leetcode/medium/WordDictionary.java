package leetcode.medium;

import java.util.regex.Pattern;

public class WordDictionary {
    // store words as long string and brute force
    StringBuilder s;
    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        s = new StringBuilder("_");
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        s.append(word).append("_");
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return Pattern.matches(".*_" + word + "_.*", s);
    }
}
