class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] freq = new int[10001];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int[] row : grid) {
            for (int v : row) {
                freq[v]++;
                min = Math.min(v, min);
                max = Math.max(v, max);
            }
        }

        if ((max - min) % x != 0) {
            return -1;
        }

        int result = 0;

        while (min < max) {
            if (freq[min] < freq[max]) {
                result += freq[min];
                freq[min + x] += freq[min];
                min += x;
            } else {
                result += freq[max];
                freq[max - x] += freq[max];
                max -= x;
            }
        }

        return freq[min] == m * n ? result : -1;
    }
}
