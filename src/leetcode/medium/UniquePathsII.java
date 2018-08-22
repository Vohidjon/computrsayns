package leetcode.medium;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0
                || obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;

        int[][] DP = new int[obstacleGrid.length][obstacleGrid[0].length];
        DP[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 1) DP[i][0] = 0;
            else DP[i][0] = DP[i - 1][0];
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] == 1) DP[0][i] = 0;
            else DP[0][i] = DP[0][i - 1];
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) DP[i][j] = 0;
                else DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
            }
        }
        return DP[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
