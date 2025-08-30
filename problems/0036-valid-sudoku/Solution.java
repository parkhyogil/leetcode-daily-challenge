class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int row = 0, col = 0, box = 0;

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if ((row & (1 << board[i][j] - '0')) != 0) {
                        return false;
                    }
                    row |= 1 << board[i][j] - '0';
                }

                if (board[j][i] != '.') {
                    if ((col & (1 << board[j][i] - '0')) != 0) {
                        return false;
                    }
                    col |= 1 << board[j][i] - '0';
                }

                int r = i / 3 * 3 + j / 3;
                int c = i % 3 * 3 + j % 3;

                if (board[r][c] != '.') {
                    if ((box & (1 << board[r][c] - '0')) != 0) {
                        return false;
                    }
                    box |= 1 << board[r][c] - '0';
                }
            }
        }

        return true;
    }
}
