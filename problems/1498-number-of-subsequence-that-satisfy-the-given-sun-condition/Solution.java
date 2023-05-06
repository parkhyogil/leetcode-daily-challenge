class Solution {
    private final int MOD = (int) 1e9 + 7;
    
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }

        int res = 0;
        for (int left = 0, right = n - 1; left <= right; ) {
            if (nums[left] + nums[right] <= target) {
                res = (res + powers[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
