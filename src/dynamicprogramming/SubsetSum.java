package dynamicprogramming;

public class SubsetSum {
    public boolean hasSubsetFor(int[] set, int sum) {
        boolean[][] DP = buildTable(set, sum);
        return DP[set.length - 1][sum];
    }

    private boolean[][] buildTable(int[] set, int sum) {
        boolean[][] DP = new boolean[set.length][sum + 1];
        for (int i = 0; i < set.length; i++) {
            DP[i][0] = true;
        }
        if (set[0] <= sum) DP[0][set[0]] = true;

        for (int i = 1; i < set.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (DP[i - 1][j]) DP[i][j] = true;
                else if(set[i] <= j) DP[i][j] = DP[i - 1][j - set[i]];
            }
        }

        return DP;
    }

    public String subsetFor(int[] set, int sum) {
        boolean[][] DP = buildTable(set, sum);
        if(DP[set.length - 1][sum]) return reconstruct(DP, set, set.length - 1, sum);
        else return "Not possible";
    }

    private String reconstruct(boolean[][] DP, int[] set, int i, int j) {
        if(set[i] == j) return "" + set[i];
        else if(DP[i - 1][j]) return reconstruct(DP, set, i - 1, j);
        else return reconstruct(DP, set, i - 1, j - set[i]) + "," + set[i];
    }
}
