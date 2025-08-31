class Solution {
    public void solveSudoku(char[][] board) {
        int[][] mask = new int[3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    mask[0][i] |= 1 << board[i][j] - '1';
                }

                if (board[j][i] != '.') {
                    mask[1][i] |= 1 << board[j][i] - '1';
                }

                if (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.') {
                    mask[2][i] |= 1 << board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - '1';
                }
            }
        }

        recur(0, 0, board, mask);
    }

    boolean recur(int r, int c, char[][] board, int[][] mask) {
        if (r == 9) {
            return true;
        }

        if (c == 9) {
            return recur(r + 1, 0, board, mask);
        }

        if (board[r][c] != '.') {
            return recur(r, c + 1, board, mask);
        }

        for (int i = 0; i < 9; i++) {
            int bit = 1 << i;

            if ((mask[0][r] & bit) > 0 || (mask[1][c] & bit) > 0 || (mask[2][r / 3 * 3 + c / 3] & bit) > 0) {
                continue;
            }

            mask[0][r] |= bit;
            mask[1][c] |= bit;
            mask[2][r / 3 * 3 + c / 3] |= bit;

            board[r][c] = (char) (i + '1');

            if (recur(r, c + 1, board, mask)) {
                return true;
            }

            mask[0][r] ^= bit;
            mask[1][c] ^= bit;
            mask[2][r / 3 * 3 + c / 3] ^= bit;
        }

        board[r][c] = '.';

        return false;
    }
}
