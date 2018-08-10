package dynamicprogramming;

public class ZeroOneKnapsackProblem {
    public String selectItems(int[] weights, int[] values, int wt) {
        int[][] table = new int[weights.length][wt + 1];

        for (int i = 1; i <= wt; i++) {
            table[0][i] = values[0];
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j <= wt; j++) {
                if (weights[i] > j) table[i][j] = table[i - 1][j];
                else table[i][j] = Math.max(table[i - 1][j], values[i] + table[i - 1][j - weights[i]]);
            }
        }

        return reconstruct(table, weights, values, weights.length - 1, wt);
    }

    private String reconstruct(int[][] table, int[] weights, int[] values, int i, int j) {
        if(table[i][j] == 0) return "";
        else if (table[i][j] == table[i - 1][j]) return reconstruct(table, weights, values, i - 1, j);
        else return  "[" + weights[i] + "(" + values[i] + ")]" + reconstruct(table, weights, values, i - 1, j - weights[i]);
    }
}
