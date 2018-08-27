package leetcode.medium;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] DP = new boolean[s.length()][s.length()];
        HashSet<String> dict = new HashSet<>(wordDict); // to make it constant time to check
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                if (dict.contains(s.substring(i, i + len + 1))) {
                    DP[i][i + len] = true;
                    continue;
                }
                for (int j = 0; j < i + len; j++) {
                    if (DP[i][j] && DP[j + 1][i + len]) {
                        DP[i][i + len] = true;
                        break;
                    }
                }
            }
        }
        return DP[0][s.length() - 1];
    }
}
