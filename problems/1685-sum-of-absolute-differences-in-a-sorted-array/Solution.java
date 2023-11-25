class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            right += nums[i];
        }

        for (int i = 0; i < n; i++) {
            res[i] = (nums[i] * i - left) + (right - nums[i] * (n - i));
            
            left += nums[i];
            right -= nums[i];
        }

        return res;
    }
}
