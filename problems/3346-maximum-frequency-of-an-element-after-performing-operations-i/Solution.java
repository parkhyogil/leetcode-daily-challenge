class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i <= max; i++) {
            freq[i] += freq[i - 1];
        }

        int result = 0;

        for (int i = 1; i <= max; i++) {
            int curr = freq[i] - freq[i - 1];
            int range =  freq[Math.min(i + k, max)] - freq[Math.max(i - k - 1, 0)] - curr;

            result = Math.max(result, curr + Math.min(range, numOperations));
        }

        return result;
    }
}
