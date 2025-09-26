class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int l = 0, r = i - 1; l < r; ) {
                if (nums[l] + nums[r] > nums[i]) {
                    result += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return result;
    }
}
