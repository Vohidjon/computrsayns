package leetcode.hard;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] DP = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) DP[0][i] = 1;

        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if(t.charAt(i - 1) == s.charAt(j - 1)) DP[i][j] = DP[i - 1][j - 1] + DP[i][j - 1];
                else DP[i][j] = DP[i][j - 1];
            }
        }

        return DP[t.length()][s.length()];
    }
}
