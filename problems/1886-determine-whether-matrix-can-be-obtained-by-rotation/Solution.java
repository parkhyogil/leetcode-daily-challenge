class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if (equals(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            rotate(mat);
            if (equals(mat, target)) {
                return true;
            }
        }
        
        return false;
    }

    void rotate(int[][] arr) {
        int n = arr.length;

        for (int k = 0; k < n / 2; k++) {
            for (int i = k, j = n - 1 - k; i < n - 1 - k; i++, j--) {
                int t = arr[k][i];
                arr[k][i] = arr[i][n - 1 - k];
                arr[i][n - 1 - k] = arr[n - 1 - k][j];
                arr[n - 1 - k][j] = arr[j][k];
                arr[j][k] = t;
            }
        }
    }

    boolean equals(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
