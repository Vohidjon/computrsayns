package dynamicprogramming;

public class RegularExpressionMatching {
    private static final char STAR = '*';
    private static final char DOT = '.';

    public boolean isMatch(String regEx, String s) {
        boolean[][] DP = new boolean[regEx.length() + 1][s.length() + 1];
        DP[0][0] = true;
        for (int i = 1; i <= regEx.length(); i++) {
            if(regEx.charAt(i - 1) == STAR) DP[i][0] = DP[i - 2][0];
        }
        for (int i = 1; i <= regEx.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(regEx.charAt(i - 1) == STAR) {
                    DP[i][j] = DP[i - 2][j] || (DP[i][j - 1] && regEquals(regEx.charAt(i - 1 - 1), s.charAt(j - 1)));
                } else DP[i][j] = DP[i - 1][j - 1] && regEquals(regEx.charAt(i - 1), s.charAt(j - 1));
            }
        }
        return DP[regEx.length()][s.length()];
    }

    private boolean regEquals(char i, char j) {
        if(i == DOT) return true;
        else return i == j;
    }
}
