class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int result = n;

        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && (long) nums[i] * k >= nums[j]) {
                j++;
            }

            result = Math.min(result, n - (j - i));
        }

        return result;
    }
}
