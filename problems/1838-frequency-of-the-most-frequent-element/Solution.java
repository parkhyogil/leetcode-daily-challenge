class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int operCount = 0;
        int prev = nums[0];
        int res = 0; 

        for (int l = 0, r = 0; r < n; r++) {
            operCount += (nums[r] - prev) * (r - l);
            prev = nums[r];

            while (operCount > k) {
                operCount -= prev - nums[l++];
            }

            res = Math.max(res, r - l + 1);
        }
        
        return res;
    }
}
