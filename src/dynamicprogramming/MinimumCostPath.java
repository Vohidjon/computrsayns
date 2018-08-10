package dynamicprogramming;

public class MinimumCostPath {
    public int cost(int[][] values) {
        if(values.length == 0) return 0;

        int[][] costs = buildTable(values);
        return costs[values.length - 1][values[0].length - 1];
    }

    public String minPath(int[][] values) {
        if(values.length == 0) return "";

        int[][] costs = buildTable(values);

        return minPath(costs, values, values.length - 1, values[0].length - 1);
    }

    private String minPath(int[][] costs, int[][] values, int i, int j) {
        if(i == 0 && j == 0) return values[i][j] + "";
        else if(i == 0) return minPath(costs, values, 0, j - 1) +  "," + values[i][j];
        else if(j == 0) return minPath(costs, values, i - 1, 0) + "," + values[i][j];
        else if(costs[i - 1][j] < costs[i][j - 1]) return minPath(costs, values, i - 1, j) + "," + values[i][j];
        else return minPath(costs, values, i, j - 1) + "," + values[i][j];
    }

    private int[][] buildTable(int[][] values) {
        int[][] costs = new int[values.length][values[0].length];
        costs[0][0] = values[0][0];

        for (int i = 1; i < values.length; i++) {
            costs[i][0] = costs[i - 1][0] + values[i][0];
        }

        for (int i = 1; i < values[0].length; i++) {
            costs[0][i] = costs[0][i - 1] + values[0][i];
        }

        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < values[0].length; j++) {
                costs[i][j] = Math.min(costs[i - 1][j], costs[i][j - 1]) + values[i][j];
            }
        }

        return costs;
    }


}
