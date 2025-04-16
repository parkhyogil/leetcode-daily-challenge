class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> countMap = new HashMap<>();
        long pairs = 0;

        long result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            pairs += countMap.merge(nums[r], 1, Integer::sum) - 1;

            while (pairs - (countMap.get(nums[l]) - 1) >= k) {
                pairs -= countMap.merge(nums[l++], -1, Integer::sum);
            }

            if (pairs >= k) {
                result += l + 1;
            }
        }

        return result;
    }
}
