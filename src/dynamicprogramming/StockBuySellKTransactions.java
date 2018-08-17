package dynamicprogramming;

public class StockBuySellKTransactions {
    public int maxProfit(int[] prices, int k) {
        int[][] table = buildTable(prices, k);

        return table[k][prices.length - 1];
    }

    public String maxProfitTransactions(int[] prices, int k) {
        int[][] table = buildTable(prices, k);

        return reconstruct(table, prices, k, prices.length - 1);
    }

    private String reconstruct(int[][] profits, int[] prices, int i, int j) {
        if(i == 0) return "";
        else {
            while (profits[i][j] == profits[i][j - 1]) j--;
            int sell = j;
            int leftProfit = profits[i][j] - prices[j];
            while (profits[i - 1][j] - prices[j] != leftProfit) j--;
            int buy = j;
            return reconstruct(profits, prices, i - 1, j) + ",[" + buy + "," + sell + "]";
        }
    }

    private int[][] buildTable(int[] prices, int k) {
        int[][] profits = new int[k + 1][prices.length];

        for (int i = 1; i < profits.length; i++) {
            int maxDiff = profits[i - 1][0] - prices[0];
            for (int j = 1; j < profits[i].length; j++) {
                profits[i][j] = Math.max(profits[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, profits[i - 1][j] - prices[j]);
            }
        }
        return profits;
    }
}
