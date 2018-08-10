package dynamicprogramming;

public class LongestCommonSubstring {
    public String substring(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return "";
        int[][] table = new int[s.length() + 1][t.length() + 1];
        int endIndex = -1;
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    if(table[i][j] > max) {
                        max = table[i][j];
                        endIndex = i - 1;
                    }
                } else table[i][j] = 0;
            }
        }
        return endIndex == -1 ? "" : s.substring(endIndex - max + 1, endIndex + 1);
    }
}
