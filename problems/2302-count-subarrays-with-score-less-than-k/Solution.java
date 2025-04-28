class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        long result = 0;
        long sum = 0;

        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];

            while (k <= sum * (r - l + 1)) {
                sum -= nums[l++];
            }

            result += r - l + 1;
        }

        return result;
    }
}
