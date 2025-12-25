class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        Arrays.sort(happiness);

        long result = 0;

        for (int i = 0; i < k; i++) {
            result += Math.max(happiness[n - 1 - i] - i, 0);
        }

        return result;
    }
}
