class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        for (char[] row : box) {
            pushToRight(row);
        }

        return rotate(box);
    }

    char[][] rotate(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        char[][] result = new char[n][m];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result[c][m - 1 - r] = matrix[r][c];
            }
        }

        return result;
    }

    void pushToRight(char[] row) {
        int length = row.length;

        int idx = length;

        for (int i = length - 1; i >= 0; i--) {
            if (row[i] == '#') {
                row[i] = '.';
                row[--idx] = '#';
            } else if (row[i] == '*') {
                idx = i;
            }
        }
    }
}
