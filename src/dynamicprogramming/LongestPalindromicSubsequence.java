package dynamicprogramming;

public class LongestPalindromicSubsequence {
    public String subsequence(String s) {
        int[][] DP = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            DP[i][i] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if(s.charAt(j) == s.charAt(j + i)) DP[j][j + i] = 2 + DP[j + 1][j + i - 1];
                else DP[j][j + i] = Math.max(DP[j][j + i - 1], DP[j + 1][j + i]);
            }
        }

        return reconstruct(s, DP, 0, s.length() - 1);
    }

    private String reconstruct(String s, int[][] DP, int i, int j) {
        if(i == j) return s.charAt(i) + "";
        else if(s.charAt(i) == s.charAt(j)) return s.charAt(i) + reconstruct(s, DP, i + 1, j - 1) + s.charAt(j);
        else if(DP[i][j] == DP[i][j - 1]) return reconstruct(s, DP, i, j - 1);
        else return reconstruct(s, DP, i + 1, j);
    }
}
