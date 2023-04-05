class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;

        long res = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res = Math.max(res, (sum + i) / (i + 1));
        }
        return (int) res;
    }
}
