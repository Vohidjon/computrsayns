package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int[] locs = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            List<Integer> loc = new ArrayList<>();
            int fromIndex = 0;
            int found = -1;
            while ((found = s.indexOf(words[i], fromIndex)) != -1) {
                loc.add(found);
                fromIndex = found + words[i].length();
            }
        }
        return null;
    }
}
