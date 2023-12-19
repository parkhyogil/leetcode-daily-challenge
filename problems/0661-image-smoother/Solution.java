class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int sum = 0;
                int count = 0;

                for (int i = r - 1; i <= r + 1; i++) {
                    for (int j = c - 1; j <= c + 1; j++) {
                        if (i >= 0 && i < m && j >= 0 && j < n) {
                            sum += img[i][j] % 256;
                            count++;
                        }
                    }
                }

                img[r][c] += sum / count * 256;
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                img[r][c] /= 256;
            }
        }

        return img;
    }
}
