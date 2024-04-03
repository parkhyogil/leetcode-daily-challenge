class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (recur(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recur(int r, int c, int idx, char[][] board, String word) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }

        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = ' ';

        boolean res = recur(r - 1, c, idx + 1, board, word) || recur(r + 1, c, idx + 1, board, word) ||
                recur(r, c - 1, idx + 1, board, word) || recur(r, c + 1, idx + 1, board, word);
        
        board[r][c] = temp;
        return res;
    }
}
