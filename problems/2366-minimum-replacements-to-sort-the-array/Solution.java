class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        
        long res = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            
            int q = (nums[i] + nums[i + 1] - 1) / nums[i + 1];
            res += q - 1;
            nums[i] /= q;
        }
        return res;
    }
}
