class Solution {
    Integer[][] cache;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        cache = new Integer[n][n + 1];
        int diff = recur(0, 1, piles);

        int sum = 0;
        for (int x : piles) {
            sum += x;
        }

        return (sum - diff) / 2 + diff;
    }

    int recur(int i, int m, int[] arr) {
        if (i == arr.length) {
            return 0;
        }

        if (cache[i][m] != null) {
            return cache[i][m];
        }

        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int x = 1; x <= 2 * m && i + x <= arr.length; x++) {
            sum += arr[i + x - 1];
            result = Math.max(result, sum - recur(i + x, Math.max(x, m), arr));
        }

        return cache[i][m] = result;
    }
}
