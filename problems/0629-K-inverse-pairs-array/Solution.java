class Solution {
    public int kInversePairs(int n, int k) {
        int mod = (int) 1e9 + 7;

        int[] prev = new int[k + 1];
        prev[0] = 1;

        for (int i = 2; i <= n; i++) {
            int[] curr = new int[k + 1];
            long sum = 0;

            for (int j = 0; j <= k; j++) {
                sum += prev[j];
                if (j - i>= 0) {
                    sum -= prev[j - i];
                }
                curr[j] = (int) (sum % mod);
            }
            prev = curr;
        }

        return prev[k];
    }
}
