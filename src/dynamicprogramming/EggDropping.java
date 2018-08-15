package dynamicprogramming;

public class EggDropping {
    public int maxDrops(int floors, int eggs) {
        int[][] drops = buildTable(floors, eggs);
        return drops[eggs][floors];
    }

    private int[][] buildTable(int floors, int eggs) {
        int[][] drops = new int[eggs + 1][floors + 1];
        drops[1][1] = 1;

        for (int i = 2; i <= floors; i++) drops[1][i] = i;

        for (int i = 2; i <= eggs; i++) drops[i][1] = 1;

        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                if(i > j) drops[i][j] = drops[i - 1][j];
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = 1; k <= j; k++) {
                        int max = Integer.max(drops[i - 1][k - 1], drops[i][j - k]);
                        if(min > max) min = max;
                    }
                    drops[i][j] = 1 + min;
                }
            }
        }
        return drops;
    }
}
