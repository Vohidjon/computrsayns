package leetcode.hard;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int k = 2;
        int[][] profits = new int[k + 1][prices.length];

        for (int i = 1; i < profits.length; i++) {
            int maxDiff = profits[i - 1][0] - prices[0];
            for (int j = 1; j < profits[i].length; j++) {
                profits[i][j] = Math.max(profits[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, profits[i - 1][j] - prices[j]);
            }
        }
        return profits[k][prices.length - 1];
    }
}
