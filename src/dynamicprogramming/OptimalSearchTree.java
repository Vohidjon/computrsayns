package dynamicprogramming;

import trees.BSTNode;

public class OptimalSearchTree {
    private static final int COSTS = 0;
    private static final int TREE_STRUCTURE = 1;
    public int optimalCost(int[] keys, int[] frequencies) {
        int[][] costs = buildTable(keys, frequencies)[COSTS];
        return costs[0][keys.length - 1];
    }

    public BSTNode optimalTree(int[] keys, int[] frequencies) {
        int[][] structure = buildTable(keys, frequencies)[TREE_STRUCTURE];
        return reconstruct(keys, structure, 0, keys.length - 1);
    }

    private BSTNode reconstruct(int[] keys, int[][] structure, int i, int j) {
        if(i >= keys.length || j < 0) return null;

        if(i == j) return new BSTNode(keys[i], null, null);
        return new BSTNode(keys[structure[i][j]],
                reconstruct(keys, structure, i, structure[i][j] - 1),
                reconstruct(keys, structure, structure[i][j] + 1, j));
    }

    private int[][][] buildTable(int[] keys, int[] frequencies) {
        int[][] costs = new int[keys.length][keys.length];
        int[][] structure = new int[keys.length][keys.length];
        for (int i = 0; i < keys.length; i++) costs[i][i] = frequencies[i];
        for (int i = 1; i < keys.length; i++) {
            for (int j = 0; j < keys.length - i; j++) {
                int sum = 0;
                for (int k = j; k <= j + i; k++) {
                    sum += frequencies[k];
                }
                int min = Integer.MAX_VALUE;
                for (int k = j; k <= j + i; k++) {
                    int cost = 0;
                    if(k != j) cost += costs[j][k - 1];
                    if(k != j + i) cost += costs[k + 1][j + i];
                    if(cost < min) {
                        min = cost;
                        structure[j][j + i] = k;
                    }
                }
                costs[j][j + i] = sum + min;
            }
        }
        return new int[][][] {costs, structure};
    }
}
