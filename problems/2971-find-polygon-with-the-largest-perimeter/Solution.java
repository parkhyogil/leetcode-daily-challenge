class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        long res = -1;
        long sum = nums[0] + nums[1];

        for (int i = 2; i < n; i++) {
            if (sum > nums[i]) {
                res = sum + nums[i];
            }

            sum += nums[i];
        }

        return res;
    }
}
