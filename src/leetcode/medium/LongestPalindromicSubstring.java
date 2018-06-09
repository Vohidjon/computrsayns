package leetcode.medium;


public class LongestPalindromicSubstring {
    public static String solution(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && i - j + 1 > longest.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    boolean isPol = true;
                    int start = j + 1;
                    int end = i - 1;
                    while (start <= end) {
                        if (s.charAt(start++) != s.charAt(end--)) {
                            isPol = false;
                            break;
                        }
                    }
                    if (isPol) longest = s.substring(j, i + 1);
                }
            }
        }
        return longest;
    }
    public static String solution2(String s) {
        if(s.length() <= 1) return s;
        String max = "";
        for (int i = 0; i < s.length() - 1; i++) {
            // 2 cases
            // 1st case: potential substring is odd-length and i is in middle
            int start = i;
            int end = i;
            while (--start >= 0 & ++end < s.length()) {
                if(s.charAt(start) != s.charAt(end)) break;
            }

            if(end - start - 1 > max.length()) max = s.substring(start + 1, end);

            // 2nd case: potential substring is even-length and i is left
            if(s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                end = i + 1;
                while (--start >= 0 & ++end < s.length()) {
                    if(s.charAt(start) != s.charAt(end)) break;
                }

                if(end - start - 1 > max.length()) max = s.substring(start + 1, end);
            }

        }
        return max;
    }

    private static String solution2Rec(String s) {
        boolean isPol = true;
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                isPol = false;
                break;
            }
        }
        if(isPol) return s;

        String left = solution2Rec(s.substring(0, s.length() - 1));
        String right = solution2Rec(s.substring(1, s.length()));

        if(left.length() >= right.length()) return  left;
        else return right;
    }
}
