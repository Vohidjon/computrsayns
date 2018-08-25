package leetcode.hard;

public class PalindromePartitioningII {
    public int minCut(String s) {
        if(s.length() < 2) return 0;
        int[][] DP = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) DP[i][i] = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            DP[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 0 : 1;
        }
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                if(DP[i + 1][j - 1] == 0 && s.charAt(i) == s.charAt(j)) {
                    DP[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, DP[i][k] + 1 + DP[k + 1][j]);
                    }
                    DP[i][j] = min;
                }
            }
        }
        return DP[0][s.length() - 1];
    }
}
