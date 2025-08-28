class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        int[][] result = new int[n][n];

        int len = n;

        for (int i = 0; i < n; i++) {
            int[] arr = new int[len];

            for (int j = 0, r = i, c = 0; r < n && c < n; j++, r++, c++) {
                arr[j] = grid[r][c];
            }

            Arrays.sort(arr);

            for (int j = len - 1, r = i, c = 0; r < n && c < n; j--, r++, c++) {
                result[r][c] = arr[j];
            }

            len--;
        }

        len = n - 1;

        for (int i = 1; i < n; i++) {
            int[] arr = new int[len];

            for (int j = 0, r = 0, c = i; r < n && c < n; j++, r++, c++) {
                arr[j] = grid[r][c];
            }

            Arrays.sort(arr);

            for (int j = 0, r = 0, c = i; r < n && c < n; j++, r++, c++) {
                result[r][c] = arr[j];
            }

            len--;
        }

        return result;
    }
}
