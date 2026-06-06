class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int pref = 0;
        for (int x : nums) {
            pref += x;
        }

        int[] result = new int[n];

        int suff = 0;
        for (int i = n - 1; i >= 0; i--) {
            pref -= nums[i];
            result[i] = Math.abs(pref - suff);
            suff += nums[i];
        }

        return result;
    }
}
