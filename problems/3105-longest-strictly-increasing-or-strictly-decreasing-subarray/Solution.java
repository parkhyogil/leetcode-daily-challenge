class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int d = nums[1] > nums[0] || nums[1] < nums[0] ? 2 : 1;
        int result = d;

        for (int i = 2; i < n; i++) {
            if ((nums[i] > nums[i - 1] && nums[i - 1] > nums[i - 2]) || (nums[i] < nums[i - 1] && nums[i - 1] < nums[i - 2])) {
                d++;
            } else {
                d = nums[i] > nums[i - 1] || nums[i] < nums[i - 1] ? 2 : 1;
            }

            result = Math.max(result, d);
        }

        return result;
    }
}
