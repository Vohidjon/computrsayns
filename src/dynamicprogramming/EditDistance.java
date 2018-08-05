package dynamicprogramming;

public class EditDistance {
    private static final int MATCH = 0;
    private static final int INSERTION = 1;
    private static final int DELETION = 2;

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     * @param s
     * @param t
     * @return
     */
    public int findDistance(String s, String t) {
        Entry[][] costs = new Entry[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) costs[i][0] = new Entry(i, INSERTION);
        for (int i = 0; i <= t.length(); i++) costs[0][i] = new Entry(i, DELETION);
        int[] options = new int[3];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                options[MATCH] = costs[i - 1][j - 1].cost + matchCost(s.charAt(i - 1), t.charAt(j - 1));
                options[INSERTION] = costs[i][j - 1].cost + insertCost(s.charAt(j - 1));
                options[DELETION] = costs[i][j - 1].cost + deleteCost(s.charAt(j - 1));

                costs[i][j] = new Entry(options[MATCH], MATCH);
                for (int k = INSERTION; k <= DELETION; k++) {
                    if (costs[i][j].cost > options[k]) {
                        costs[i][j].cost = options[k];
                        costs[i][j].parent = k;
                    }
                }
            }
        }

        return costs[s.length() - 1][t.length() - 1].cost;
    }

    private int deleteCost(char a) {
        return 1;
    }

    private int insertCost(char a) {
        return 1;
    }

    private int matchCost(char a, char b) {
        return a == b ? 0 : 1;
    }

    class Entry {
        int cost;
        int parent;
        public Entry(int cost, int parent) {
            this.cost = cost;
            this.parent = parent;
        }
    }
}
