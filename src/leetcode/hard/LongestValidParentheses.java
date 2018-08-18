package leetcode.hard;


public class LongestValidParentheses {
    private static final char OPENING = '(';
    private static final char CLOSING = ')';
    public static int longestValidParentheses(String s) {
        int[] DP = new int[s.length()];
        for (int i = 0; i < s.length(); i++) DP[i] = -1;
        for (int j = 1; j < s.length(); j++) {
            if(s.charAt(j) == CLOSING) {
                int i = DP[j - 1] == -1 ? j - 1 : DP[j - 1] - 1;
                if(i >= 0 && isMatch(s.charAt(i), s.charAt(j))) {
                    DP[j] = i;
                    if(i > 0 && DP[i - 1] != -1) {
                        DP[j] = DP[i - 1];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (DP[i] != -1) {
                max = Math.max(max, i - DP[i] + 1);
            }
        }
        return max;
    }

    private static boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')');
    }
}
