class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[] result = new int[m * n];

        int idx = 0;
        int dir = 0;

        int r = 0, c = 0;

        while (idx < m * n) {
            while (true) {
                result[idx++] = mat[r][c];

                int nr = r + (dir == 0 ? -1 : 1);
                int nc = c + (dir == 0 ? 1 : -1);

                if (nr < 0 || nc < 0 || nr == m || nc == n) {
                    break;
                }

                r = nr;
                c = nc;
            }

            if (dir == 0) {
                if (c == n - 1) {
                    r++;
                } else {
                    c++;
                }
            } else {
                if (r == m - 1) {
                    c++; 
                } else {
                    r++;
                }
            }

            dir ^= 1;
        }

        return result;
    }
}
