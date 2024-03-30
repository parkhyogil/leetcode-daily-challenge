class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;

        int[] count = new int[n + 1];
        int diff = 0;
        int currCount = 0;

        int res = 0;

        for (int l = 0, r = 0; r < n; r++) {
            if (count[nums[r]] == 0) {
                diff++;
            }
            count[nums[r]]++;

            if (diff > k) {
                count[nums[l++]]--;
                diff--;
                currCount = 0;
            }

            if (diff == k) {
                while (count[nums[l]] > 1) {
                    count[nums[l++]]--;
                    currCount++;
                }
                res += currCount + 1;
            }
        }

        return res;
    }
}
