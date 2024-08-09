class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int result = 0;

        for (int r = 0; r < row - 2; r++) {
            for (int c = 0; c < col - 2; c++) {
                if (isMagicSquare(r, c, grid)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMagicSquare(int row, int col, int[][] grid) {
        if (isWrongNumberInSquare(row, col, grid)) {
            return false;
        }

        int targetSum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        for (int r = row; r <= row + 2; r++) {
            int sum = 0;
            for (int c = col; c <= col + 2; c++) {
                sum += grid[r][c];
            }

            if (sum != targetSum) {
                return false;
            }
        }

        for (int c = col; c <= col + 2; c++) {
            int sum = 0;
            for (int r = row; r <= row + 2; r++) {
                sum += grid[r][c];
            }

            if (sum != targetSum) {
                return false;
            }
        }

        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != targetSum) {
            return false;
        }

        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != targetSum) {
            return false;
        }
        
        return true;
    }

    private boolean isWrongNumberInSquare(int row, int col, int[][] grid) {
        boolean[] contains = new boolean[10];

        for (int r = row; r <= row + 2; r++) {
            for (int c = col; c <= col + 2; c++) {
                if (grid[r][c] < 1 || grid[r][c] > 9 || contains[grid[r][c]]) {
                    return true;
                }
                contains[grid[r][c]] = true;
            }
        }

        return false;
    }
}
