package leetcode.medium;

import java.util.LinkedList;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // use DFS
        if(grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] processed = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !processed[i][j]) {
                    count++;
                    process(grid, processed, i, j);
                }
            }
        }
        return count;
    }

    private void process(char[][] grid, boolean[][] processed, int i, int j) {
        processed[i][j] = true;
        // up
        if(i - 1 >= 0 && grid[i - 1][j] == '1' && !processed[i - 1][j]) {
            process(grid, processed, i - 1, j);
        }
        // down
        if (i + 1 < grid.length && grid[i + 1][j] == '1' && !processed[i + 1][j]) {
            process(grid, processed, i + 1, j);
        }
        // left
        if (j - 1 >= 0 && grid[i + 1][j] == '1' && !processed[i][j - 1]) {
            process(grid, processed, i, j - 1);
        }
        // right
        if (j + 1 < grid[0].length && grid[i + 1][j] == '1' && !processed[i][j - 1]) {
            process(grid, processed, i, j = 1);
        }
    }
}
