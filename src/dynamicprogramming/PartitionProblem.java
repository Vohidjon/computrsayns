package dynamicprogramming;

public class PartitionProblem {

    private static final int COSTS = 0;
    private static final int PARTITIONS = 1;

    public int maxPartition(int[] values, int k) {
        int[][][] table = this.buildTable(values, k);
        return table[COSTS][values.length - 1][k - 1];
    }

    public String partition(int[] values, int k) {
        int[][][] table = this.buildTable(values, k);
        return this.partition(table[PARTITIONS], values.length, k);
    }

    private String partition(int[][] partitions, int n, int k) {
        if(partitions[n - 1][k - 1] == -1) {
            return "[" + 1 + "," + n + "]";
        } else {
            return this.partition(partitions, partitions[n - 1][k - 1] + 1 ,k - 1) + "[" + (partitions[n - 1][k - 1] + 1 + 1) + "," + n + "]";
        }
    }

    private int[][][] buildTable(int[] values, int k) {
        int[][] costs = new int[values.length][k];
        int[][] partitions = new int[values.length][k];
        int[] prefixSums = new int[values.length];

        prefixSums[0] = values[0];
        for (int i = 1; i < values.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + values[i];
        }

        for (int i = 0; i < values.length; i++) {
            costs[i][0] = prefixSums[i];
            partitions[i][0] = -1;
        }

        for (int i = 0; i < k; i++) {
            costs[0][i] = values[0];
            partitions[0][i] = -1;
        }
        
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < k; j++) {
                costs[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= i; l++) {
                    int cost = Math.max(costs[l][j - 1], prefixSums[i] - prefixSums[l]);
                    if (costs[i][j] > cost) {
                        costs[i][j] = cost;
                        partitions[i][j] = l;
                    }
                }
            }
        }
        return new int[][][]{costs, partitions};
    }
}
