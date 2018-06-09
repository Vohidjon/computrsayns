package leetcode.medium;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int longest = 0;
        int start = 0;
        int end = 1;
        while (end < s.length()) {
            if (end - start > longest) longest = end - start; // updates longest
            char ch = s.charAt(end);
            if (s.substring(start, end).contains(ch + "")) { // already in substring
                start = start + 1;
                continue;
            }
            end++;
        }
        if (end - start > longest) longest = end - start; // updates longest
        return longest;
    }
}
