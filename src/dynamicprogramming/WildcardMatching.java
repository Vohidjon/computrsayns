package dynamicprogramming;

public class WildcardMatching {
    private static final char STAR = '*';
    private static final char QUESTION = '?';
    public boolean isMatch(String regEx, String s) {
        boolean[][] DP = new boolean[regEx.length() + 1][s.length() + 1];
        DP[0][0] = true;

        for (int i = 1; i <= regEx.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(regEx.charAt(i - 1) == STAR) {
                    DP[i][j] = DP[i - 1][j] || DP[i][j - 1];
                } else DP[i][j] = DP[i - 1][j - 1] && regEquals(regEx.charAt(i - 1), s.charAt(j - 1));
            }
        }

        return DP[regEx.length()][s.length()];
    }

    private boolean regEquals(char i, char j) {
        if(i == QUESTION) return true;
        else return i == j;
    }
}
