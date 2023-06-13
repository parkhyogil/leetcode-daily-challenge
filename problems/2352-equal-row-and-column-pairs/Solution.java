class Solution {
    private int n;
    private int[][] grid;

    public int equalPairs(int[][] grid) {
        n = grid.length;
        this.grid = grid;

        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (isSameRowAndColumn(r, c)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isSameRowAndColumn(int r, int c) {
        for (int i = 0; i < n; i++) {
            if (grid[r][i] != grid[i][c]) {
                return false;
            }
        }
        return true;
    }
}
