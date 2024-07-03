class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;

        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;

        for (int l = 0, r = n - 4; l < 4; l++, r++) {
            res = Math.min(res, nums[r] - nums[l]);
        }

        return res;
    }
}
