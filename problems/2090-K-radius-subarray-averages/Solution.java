class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        long sum = 0;
        int[] res = new int[n];
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            res[r] = -1;

            if (r - l == k * 2) {
                res[r - k] = (int) (sum / (k * 2 + 1));
                sum -= nums[l++];
            }
        }
        return res;
    }
}
