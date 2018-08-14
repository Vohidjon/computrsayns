package dynamicprogramming;

public class CuttingRod {
    public int maxProfit(int[] cuts, int[] prices, int length) {
        int[][] profits = buildTable(cuts, prices, length);
        return profits[cuts.length][length];
    }

    public String maxProfitCuts(int[] cuts, int[] prices, int length) {
        int[][] profits = buildTable(cuts, prices, length);
        return reconstruct(profits, cuts, prices, cuts.length, length);
    }

    private String reconstruct(int[][] profits, int[] cuts, int[] prices, int i, int j) {
        if(i == 0 || j == 0) {
            return "";
        }
        else if(profits[i][j] == profits[i - 1][j]) return reconstruct(profits, cuts, prices, i - 1, j);
        else return reconstruct(profits, cuts, prices, i, j - cuts[i - 1]) + ",{" + cuts[i - 1] + "(" + prices[i - 1] + ")}";
    }

    private int[][] buildTable(int[] cuts, int[] prices, int length) {
        int[][] profits = new int[cuts.length + 1][length + 1];
        for (int i = 1; i <= cuts.length; i++) {
            for (int j = 1; j <= length; j++) {
                if(j < cuts[i - 1]) profits[i][j] = profits[i - 1][j];
                else profits[i][j] = Math.max(profits[i - 1][j], profits[i][j - cuts[i - 1]] + prices[i - 1]);
            }
        }
        return profits;
    }
}
