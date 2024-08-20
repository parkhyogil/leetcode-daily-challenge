class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] cache = new int[n][n];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        int diff = recur(0, 1, piles, cache);

        return (sum + diff) / 2;
    }

    private int recur(int idx, int m, int[] piles, int[][] cache) {
        if (idx == piles.length) {
            return 0;
        }

        if (cache[idx][m] != -1) {
            return cache[idx][m];
        }

        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int x = 1; x <= 2 * m && idx + x <= piles.length; x++) {
            sum += piles[idx + x - 1];

            result = Math.max(result, sum - recur(idx + x, Math.max(x, m), piles, cache));
        }

        return cache[idx][m] = result;
    }
}
