package leetcode.hard;

public class DungeonGame {
    private static final int HP = 0;
    private static final int MIN_HP = 1;
    private static final int SUM_HP = 2;
    public int calculateMinimumHP(int[][] dungeon) {
        int[][][] DP = new int[dungeon.length][dungeon[0].length][3];
        DP[0][0][SUM_HP] = dungeon[0][0];
        DP[0][0][MIN_HP] = 1 - Math.min(dungeon[0][0], 0);
        DP[0][0][HP] = DP[0][0][MIN_HP] + dungeon[0][0];

        for (int i = 1; i < dungeon.length; i++) {
            DP[i][0][SUM_HP] = DP[i - 1][0][SUM_HP] + dungeon[i][0];
            if(DP[i - 1][0][HP] + dungeon[i][0] <= 0) { // need to increase MIN_HP
                DP[i][0][MIN_HP] = DP[i - 1][0][MIN_HP] - (DP[i - 1][0][HP] + dungeon[i][0]) + 1;
            } else {
                DP[i][0][MIN_HP] = DP[i - 1][0][MIN_HP];
            }
            DP[i][0][HP] = DP[i][0][MIN_HP] + DP[i][0][SUM_HP];
        }
        for (int j = 1; j < dungeon[0].length; j++) {
            DP[0][j][SUM_HP] = DP[0][j - 1][SUM_HP] + dungeon[0][j];
            if(DP[0][j - 1][HP] + dungeon[0][j] <= 0) { // need to increase MIN_HP
                DP[0][j][MIN_HP] = DP[0][j - 1][MIN_HP] - (DP[0][j - 1][HP] + dungeon[0][j]) + 1;
            } else {
                DP[0][j][MIN_HP] = DP[0][j - 1][MIN_HP];
            }
            DP[0][j][HP] = DP[0][j][MIN_HP] + DP[0][j][SUM_HP];
        }

        for (int i = 1; i < dungeon.length; i++) {
            for (int j = 1; j < dungeon[i].length; j++) {
                int ii;
                int jj;
                if(DP[i - 1][j][MIN_HP] < DP[i][j - 1][MIN_HP]) {
                    ii = i - 1;
                    jj = j;
                } else if(DP[i][j - 1][MIN_HP] < DP[i - 1][j][MIN_HP]) {
                    ii = i;
                    jj = j - 1;
                } else {
                    if (DP[i - 1][j][HP] >= DP[i][j - 1][HP]) {
                        ii = i - 1;
                        jj = j;
                    } else {
                        ii = i;
                        jj = j - 1;
                    }
                }

                DP[i][j][SUM_HP] = DP[ii][jj][SUM_HP] + dungeon[i][j];
                if(DP[ii][jj][HP] + dungeon[i][j] <= 0) { // need to increase MIN_HP
                    DP[i][j][MIN_HP] = DP[ii][jj][MIN_HP] - (DP[ii][jj][HP] + dungeon[i][j]) + 1;
                } else {
                    DP[i][j][MIN_HP] = DP[ii][jj][MIN_HP];
                }
                DP[i][j][HP] = DP[i][j][MIN_HP] + DP[i][j][SUM_HP];
            }
        }

        return DP[dungeon.length - 1][dungeon[0].length - 1][MIN_HP];
    }
}
