class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> countOf = new HashMap<>();

        int res = 0;
        for (int l = 0, r = 0; r < n; r++) {
            countOf.put(nums[r], countOf.getOrDefault(nums[r], 0) + 1);

            while (countOf.get(nums[r]) > k) {
                countOf.put(nums[l], countOf.get(nums[l]) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
