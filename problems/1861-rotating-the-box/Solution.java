class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] result = new char[n][m];

        for (int r = 0; r < m; r++) {
            int i = n;
            for (int c = n - 1; c >= 0; c--) {
                if (boxGrid[r][c] == '*') {
                    result[c][m - 1 - r] = '*';
                    i = c;
                } else if (boxGrid[r][c] == '#') {
                    result[c][m - 1 - r] = '.';
                    result[--i][m - 1 - r] = '#';
                } else {
                    result[c][m - 1 - r] = '.';
                }
            }
        }

        return result;
    }
}
