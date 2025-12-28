class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int result = 0;

        int r = 0, c = n - 1;

        while (r < m && c >= 0) {
            if (grid[r][c] < 0) {
                result += m - r;
                c--;
            } else {
                r++;
            }
        }

        return result;
    }
}
