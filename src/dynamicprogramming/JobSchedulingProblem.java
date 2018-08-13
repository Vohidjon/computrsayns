package dynamicprogramming;

public class JobSchedulingProblem {
    public int maxProfit(int[] starts, int[] ends, int[] profits) {
        int[] table = buildTable(starts, ends, profits);

        int max = table[0];
        for (int i = 0; i < table.length; i++) {
            if(max < table[i]) max = table[i];
        }
        return max;
    }

    public String pickJobs(int[] starts, int[] ends, int[] profits) {
        int[] table = buildTable(starts, ends, profits);

        int maxIndex = 0;
        for (int i = 0; i < table.length; i++) {
            if(table[maxIndex] < table[i]) maxIndex = i;
        }
        return reconstruct(table, starts, ends, profits, maxIndex);
    }

    private String reconstruct(int[] costs, int[] starts, int[] ends,  int[] profits, int i) {
        if(costs[i] - profits[i] == 0) return "[" + starts[i] + "," + ends[i] + "]";
        else {
            int leftCost = costs[i] - profits[i];
            int j = i;
            while (true) {
                j--;
                if(costs[j] == leftCost) return reconstruct(costs, starts, ends, profits, j) + "[" + starts[i] + "," + ends[i] + "]";
            }
        }
    }

    private int[] buildTable(int[] starts, int[] ends, int[] profits) {
        int[] costs = new int[starts.length];
        for (int i = 0; i < profits.length; i++) {
            costs[i] = profits[i];
        }

        for (int i = 0; i < starts.length; i++) {
            for (int j = 0; j < i; j++) {
                if(ends[j] <= starts[i]) {
                    costs[i] = Math.max(costs[i], costs[j] + profits[i]);
                }
            }
        }
        return costs;
    }
}
