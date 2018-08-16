package dynamicprogramming;


public class CoinChangingMinimumCoins {
    public String change(int[] denominations, int money) {
        int[] minCoins = new int[money + 1];
        int[] sequence = new int[money + 1];

        for (int i = 0; i < minCoins.length; i++) {
            minCoins[i] = -1; // denotes INFINITY
            sequence[i] = -1;
        }

        minCoins[0] = 0;

        for (int i = 0; i < denominations.length; i++) {
            for (int j = denominations[i]; j <= money; j++) {
                int minCoin = minCoins[j];
                int min = sequence[j];
                if(minCoins[j - denominations[i]] != -1 && (minCoin == -1 || minCoin > 1 + minCoins[j - denominations[i]])) {
                    minCoin = 1 + minCoins[j - denominations[i]];
                    min = i;
                }
                minCoins[j] = minCoin;
                sequence[j] = min;
            }
        }

        return reconstruct(denominations, sequence, money);
    }

    private String reconstruct(int[] denominations, int[] sequence, int i) {
        if(sequence[i] == -1) return "";
        else
            return reconstruct(denominations, sequence, i - denominations[sequence[i]]) + "," + denominations[sequence[i]];
    }
}
