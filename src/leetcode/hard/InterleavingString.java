package leetcode.hard;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * The idea:
 * P[i,j] is weather substrings s1[0,i] and s2[0,j] can be used to interleave the substring s3[0, i + j]
 * The recursive relation
 * P[i,j] = (P[i - 1, j] && s1[i] == s3[i + j]) || (P[i, j - 1] && s2[j] == s3[i + j])
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];
        DP[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            DP[i][0] = DP[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j <= s2.length(); j++) {
            DP[0][j] = DP[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                DP[i][j] = (DP[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)))
                        || (DP[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return DP[s1.length()][s2.length()];
    }
}
