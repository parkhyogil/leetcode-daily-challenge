class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int result = 0;

        for (int i = 1 - n; i < n; i++) {
            for (int j = 1 - n; j < n; j++) {
                int count = 0;

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {

                        int r = i + k;
                        int c = j + l;

                        if (r >= 0 && c >= 0 && r < n && c < n && img2[k][l] == 1 && img1[r][c] == 1) {
                            count++;
                        }
                    }
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
