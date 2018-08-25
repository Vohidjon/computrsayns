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

    public String longestPalindromeDP(String s) {
        if(s.length() < 2) return s;
        boolean[][] DP = new boolean[s.length()][s.length()];
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < s.length(); i++) DP[i][i] = true;
        for (int i = 0; i < s.length() - 1; i++) {
            DP[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if(DP[i][i + 1]) {
                maxI = i;
                maxJ = i + 1;
            }
        }
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                DP[i][j] = DP[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(DP[i][j]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }
}
