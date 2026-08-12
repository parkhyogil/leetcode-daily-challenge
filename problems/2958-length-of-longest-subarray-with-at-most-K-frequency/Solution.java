class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        int result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            freq.merge(nums[r], 1, Integer::sum);

            while (freq.get(nums[r]) > k) {
                freq.merge(nums[l++], -1, Integer::sum);
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
