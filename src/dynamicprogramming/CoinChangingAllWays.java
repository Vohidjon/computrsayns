package dynamicprogramming;

public class CoinChangingAllWays {
    public int countWays(int[] denominations, int money) {
        int[][] DP = new int[denominations.length][money + 1];

        for (int i = 1; i <= money; i++) DP[0][i] = i % denominations[0] == 0 ? 1 : 0;
        for (int i = 0; i < denominations.length; i++) DP[i][0] = 1;

        for (int i = 1; i < denominations.length; i++) {
            for (int j = 1; j <= money; j++) {
                if(j >= denominations[i]) DP[i][j] = DP[i - 1][j] + DP[i][j - denominations[i]];
                else DP[i][j] = DP[i - 1][j];
            }
        }

        return DP[denominations.length - 1][money];
    }
}
