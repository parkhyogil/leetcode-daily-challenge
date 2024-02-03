class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] cache = new int[n];
        Arrays.fill(cache, -1);

        return recur(0, arr, cache, k);
    }

    private int recur(int idx, int[] arr, int[] cache, int k) {
        if (idx == arr.length) {
            return 0;
        }

        if (cache[idx] != -1) {
            return cache[idx];
        }

        int res = 0;
        int max = 0;

        for (int i = 0; i < k && idx + i < arr.length; i++) {
            max = Math.max(max, arr[idx + i]);
            res = Math.max(res, max * (i + 1) + recur(idx + i + 1, arr, cache, k));
        }

        return cache[idx] = res;
    }
}
