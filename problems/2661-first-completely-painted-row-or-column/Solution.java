class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int l = m * n;

        int[] pos = new int[l];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[mat[i][j] - 1] = i * n + j;
            }
        }

        int[] numOfPaintedOfRows = new int[m];
        int[] numOfPaintedOfCols = new int[n];

        for (int i = 0; i < l; i++) {
            int num = arr[i] - 1;
            
            int row = pos[num] / n;
            int col = pos[num] % n;
            
            numOfPaintedOfRows[row]++;
            numOfPaintedOfCols[col]++;

            if (numOfPaintedOfRows[row] == n || numOfPaintedOfCols[col] == m) {
                return i;
            }
        }
        
        return -1;
    }
}
