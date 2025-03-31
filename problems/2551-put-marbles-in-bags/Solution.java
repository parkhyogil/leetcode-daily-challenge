class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;

        if (n == k || k == 1) {
            return 0;
        }

        int[] borderSums = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            borderSums[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(borderSums);

        long diff = 0;

        for (int i = 0; i < k - 1; i++) {
            diff += borderSums[n - 2 - i] - borderSums[i];
        }

        return diff;
    }
}
