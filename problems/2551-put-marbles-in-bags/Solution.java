class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;

        if (n == k) {
            return 0;
        }

        int[] pairs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairs[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairs);

        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += pairs[n - 2 - i] - pairs[i];
        }
        return res;
    }
}
