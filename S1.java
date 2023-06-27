public class S1 {

    public boolean isValidSudoku(char[][] board) {
        return helper(0, 0, board);
    }

    public boolean helper(int row, int col, char[][] board) {

        int l = board.length;

        if (row == l) {
            return true;
        }

        int newRow = 0;
        int newCol = 0;

        if (col != l - 1) {

            newRow = row;
            newCol = col + 1;

        } else {

            newRow = row + 1;
            newCol = 0;
        }

        char c = board[row][col];

        if (c != '.') {

            if (!isSafe(row, col, board)) {
                return false;
            }

        }

        return helper(newRow, newCol, board);

    }

    public boolean isSafe(int r, int c, char[][] board) {

        char ch = board[r][c];

        for (int i = 0; i < board.length; i++) {

            if (board[r][i] == ch && i != c) {
                return false;
            }

        }

        for (int i = 0; i < board.length; i++) {

            if (board[i][c] == ch && i != r) {
                return false;
            }

        }

        for (int i = r - r % 3; i < r + 3 - r % 3; i++) {
            for (int j = c - c % 3; j < c + 3 - c % 3; j++) {

                if (board[i][j] == ch && i != r && j != c) {
                    return false;
                }

            }
        }

        return true;
    }

}
