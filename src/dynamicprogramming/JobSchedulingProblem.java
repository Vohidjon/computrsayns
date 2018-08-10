package dynamicprogramming;

public class JobSchedulingProblem {
    public int maxProfit(int[] starts, int[] ends, int[] profits) {
        int[] costs = new int[starts.length];
        for (int i = 0; i < profits.length; i++) {
            costs[i] = profits[i];
        }

        for (int i = 0; i < starts.length; i++) {
            for (int j = 0; j < i; j++) {
                if(ends[j] <= ends[i]) {
                    costs[i] = Math.max(costs[i], costs[j] + profits[i]);
                }
            }
        }

        int max = costs[0];
        for (int i = 0; i < costs.length; i++) {
            if(max < costs[i]) max = costs[i];
        }
        return max;
    }
}
