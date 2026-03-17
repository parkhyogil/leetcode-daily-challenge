class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }

        int result = 0;
        int[] count = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[j] = matrix[i][j] == 0 ? 0 : count[j] + 1;
            }

            idx.sort((a, b) -> count[b] - count[a]);

            for (int j = 0; j < n && count[idx.get(j)] > 0; j++) {
                result = Math.max(result, count[idx.get(j)] * (j + 1));
            }
        }

        return result;
    }
}
