package dynamicprogramming;

public class MatrixChainMultiplication {
    private static final int COLS = 0;
    private static final int ROWS = 1;
    private static final int COSTS = 0;
    private static final int RESULTS = 1;

    public int minCost(int[][] matrices) {
        int[][] table = buildTable(matrices)[COSTS];
        return table[0][matrices.length - 1];
    }

    public String minCostResults(int[][] matrices) {
        int[][] table = buildTable(matrices)[RESULTS];

        return reconstruct(table, 0, matrices.length - 1);
    }

    private String reconstruct(int[][] results, int i, int j) {
        if(i == j) return i + "";
        else return "(" + reconstruct(results, i, results[i][j] - 1) + "*" + reconstruct(results, results[i][j], j) + ")";
    }

    private int[][][] buildTable(int[][] matrices) {
        int[][] costs = new int[matrices.length][matrices.length];
        int[][] results = new int[matrices.length][matrices.length];
        for (int i = 1; i < matrices.length; i++) {
            for (int j = 0; j < matrices.length - i; j++) {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int k = j + 1; k <= j + i; k++) {
                    if(min > costs[j][k - 1] + costs[k][j + i] + matrices[j][COLS] * matrices[k][COLS] * matrices[j + i][ROWS]) {
                        min = costs[j][k - 1] + costs[k][j + i] + matrices[j][COLS] * matrices[k][COLS] * matrices[j + i][ROWS];
                        minIndex = k;
                    }
                }

                costs[j][j + i] = min;
                results[j][j + i] = minIndex;
            }
        }

        return new int[][][]{costs, results};
    }
}
