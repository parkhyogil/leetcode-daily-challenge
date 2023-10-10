class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int m = -1;
        for (int i = 0; i < n; i++) {
            if (m == -1 || nums[i] != nums[m]) {
                nums[++m] = nums[i];
            }
        }

        int res = n - 1;

        int maxIdx = 0;
        for (int i = 0; i <= m; i++) {
            while (maxIdx <= m && nums[i] + n - 1 >= nums[maxIdx]) {
                maxIdx++;
            }
            res = Math.min(res, n - (maxIdx - i));
        }

        return res;
    }
}
