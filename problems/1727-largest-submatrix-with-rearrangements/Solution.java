class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int c = 0; c < n; c++) {
            for (int r = 1; r < m; r++) {
                if (matrix[r][c] > 0) {
                    matrix[r][c] += matrix[r - 1][c];
                }
            }
        }

        int res = 0;
        for (int[] arr : matrix) {
            Arrays.sort(arr);

            for (int c = n - 1; c >= 0 && arr[c] > 0; c--) {
                res = Math.max(res, arr[c] * (n - c));
            }
        }
        
        return res;
    }
}
