class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        boolean[] contains = new boolean[10001];

        int result = 0;
        int sum = 0;

        for (int l = 0, r = 0; r < n; r++) {
            while (contains[nums[r]]) {
                sum -= nums[l];
                contains[nums[l]] = false;
                l++;
            }

            sum += nums[r];
            contains[nums[r]] = true;

            result = Math.max(result, sum);
        }

        return result;
    }
}
