package leetcode.easy;

public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean isMatch = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) return i;
        }
        return -1;
    }
}
