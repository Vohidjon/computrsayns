package dynamicprogramming;

public class LongestCommonSubsequence {
    public String subsequence(String s, String t) {
        int[][] table = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return reconstruct(table, s, s.length(), t.length());
    }

    private String reconstruct(int[][] table, String s, int i, int j) {
        if(table[i][j] == 0) {
            return "";
        } else if(table[i][j] == table[i - 1][j - 1] + 1) {
            return reconstruct(table, s, i - 1, j - 1) + s.charAt(i - 1);
        } else if (table[i][j] == table[i - 1][j]) {
            return reconstruct(table, s, i - 1, j);
        } else {
            return reconstruct(table, s, i, j - 1);
        }
    }
}
