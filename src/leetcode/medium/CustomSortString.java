package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String S, String T) {
        Character[] TChars = T.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new);
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            hashMap.put(S.charAt(i), i);
        }
        Arrays.sort(TChars, Comparator.comparingInt(ch -> hashMap.getOrDefault(ch, -1)));
        StringBuilder result = new StringBuilder();
        for (Character c : TChars) {
            result.append(c);
        }
        return result.toString();
    }
}
