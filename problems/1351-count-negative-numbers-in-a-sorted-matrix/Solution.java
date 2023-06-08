class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int r = 0;
        int c = n - 1;

        int res = 0;
        while (r < m && c >= 0) {
            if (grid[r][c] < 0) {
                res += m - r;
                c--;
            } else {
                r++;
            }
        }
        return res;
    }
}
