class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int start = 0;
        int end = 0;
        int res = 0;
        while (end < n - 1) {
            int max = 0;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, i + nums[i]);
            }
            start = end + 1;
            end = max;
            res++;
        }
        return res;
    }
}
