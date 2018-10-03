package leetcode.medium;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] columns = new int[9][9];
        int[][] blocks = new int[3][9];
        for (int i = 0; i < board.length; i++) {
            int[] row = new int[9];
            if (i % 3 == 0) {
                blocks = new int[3][9];
            }
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int index = (int) board[i][j] - 49;
                if ((++row[index]) == 2) return false;
                if ((++columns[j][index]) == 2) return false;
                if ((++blocks[j / 3][index]) == 2) return false;
            }
        }
        return true;
    }
}
