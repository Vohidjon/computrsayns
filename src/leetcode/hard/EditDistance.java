package leetcode.hard;

public class EditDistance {
    private static final int MATCH = 0;
    private static final int INSERTION = 1;
    private static final int DELETION = 2;

    public int minDistance(String s, String t) {
        int[][] costs = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= t.length(); i++) costs[0][i] = i;
        for (int i = 1; i <= s.length(); i++) costs[i][0] = i;
        int[] options = new int[3];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                options[MATCH] = costs[i - 1][j - 1] + matchCost(s.charAt(i - 1), t.charAt(j - 1));
                options[INSERTION] = costs[i][j - 1] + 1;
                options[DELETION] = costs[i- 1][j] + 1;

                costs[i][j] = options[MATCH];
                for (int k = INSERTION; k <= DELETION; k++) {
                    if (costs[i][j] > options[k]) {
                        costs[i][j] = options[k];
                    }
                }
            }
        }

        return costs[s.length()][t.length()];
    }

    private int matchCost(char a, char b) {
        return a == b ? 0 : 1;
    }

}
